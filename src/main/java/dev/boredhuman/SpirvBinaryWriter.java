package dev.boredhuman;

import spirv.instructions.Instruction;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SpirvBinaryWriter {
	public static void write(OutputStream out, SpirvBinary binary) {
		int size = 5;

		for (Instruction instruction : binary.instructions) {
			size += instruction.size();
		}

		// +1 per instruction for opcode and instruction length
		size += binary.instructions.length;

		int[] data = new int[size];

		data[0] = 0x07230203;
		data[1] = (binary.majorVersion & 0xFF) << 16 | (binary.minorVersion & 0xFF) << 8;
		data[2] = binary.generateMagicNumber;
		data[3] = binary.bound;
		data[4] = binary.reserved;

		BasicInstructionWriter writer = new BasicInstructionWriter(data, 5);

		for (Instruction instruction : binary.instructions) {
			int length = (instruction.size() + 1);
			int opcode = instruction.opcode();
			int lengthOpcodePacked = (length << 16) | opcode;

			writer.write(lengthOpcodePacked);
			instruction.write(writer);
		}

		byte[] dataBytes = new byte[data.length * 4];
		ByteBuffer buffer = ByteBuffer.wrap(dataBytes).order(ByteOrder.nativeOrder());
		buffer.asIntBuffer().put(data);

		try {
			out.write(dataBytes, 0, dataBytes.length);
		} catch (Throwable err) {
			throw new RuntimeException("Failed to write spirv binary to given stream", err);
		}
	}
}
