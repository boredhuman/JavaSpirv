package spirv.instructions;

import java.nio.charset.StandardCharsets;

public class InstructionUtil {

	public static int wordCount(byte[] stringBytes) {
		return stringBytes.length / 4 + 1;
	}

	public static int wordCount(String string) {
		return string.getBytes(StandardCharsets.UTF_8).length / 4 + 1;
	}

	public static int wordCount(String[] stringArray) {
		int wordCount = 0;
		for (String string : stringArray) {
			wordCount += InstructionUtil.wordCount(string);
		}
		return wordCount;
	}

	public static void writeString(int[] data, int offset, byte[] stringBytes) {
		for (int i = 0, len = InstructionUtil.wordCount(stringBytes); i < len; i++) {
			int word = 0;
			int readOffset = i * 4;
			for (int j = 0; j < 4 && readOffset + j < stringBytes.length; j++) {
				int stringByte = stringBytes[readOffset + j] & 0xFF;
				word |= (stringByte << j * 8);
			}
			data[offset + i] = word;
		}
	}

	public static StringData readString(int[] data, int offset) {
		int stringLen = 0;
		int wordCount = 0;
		exit:
		for (int i = offset, len = data.length; i < len; i++) {
			wordCount++;
			int word = Integer.reverseBytes(data[i]);
			int mask = 0xFF000000;
			for (int j = 0; j < 4; j++) {
				if ((word & mask) != 0) {
					stringLen++;
				} else {
					break exit;
				}
				mask >>>= 8;
			}
		}

		byte[] stringData = new byte[stringLen];
		int len = stringLen / 4 + (stringLen % 4 == 0 ? 0 : 1);
		stringLen = 0;
		for (int i = 0; i < len; i++) {
			int word = Integer.reverseBytes(data[i + offset]);
			int mask = 0xFF000000;
			for (int j = 0; j < 4; j++) {
				if ((word & mask) != 0) {
					stringData[stringLen++] = (byte) ((word >> (3 - j) * 8) & 0xFF);
				} else {
					break;
				}
				mask >>>= 8;
			}
		}

		return new StringData(new String(stringData, StandardCharsets.UTF_8), wordCount);
	}
}
