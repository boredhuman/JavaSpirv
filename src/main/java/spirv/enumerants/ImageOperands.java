package spirv.enumerants;

import spirv.instructions.Instruction;

public class ImageOperands {
	public static final int NONE = 0x0000;
	public static final int BIAS = 0x0001;
	public static final int LOD = 0x0002;
	public static final int GRAD = 0x0004;
	public static final int CONST_OFFSET = 0x0008;
	public static final int OFFSET = 0x0010;
	public static final int CONST_OFFSETS = 0x0020;
	public static final int SAMPLE = 0x0040;
	public static final int MIN_LOD = 0x0080;
	public static final int MAKE_TEXEL_AVAILABLE = 0x0100;
	public static final int MAKE_TEXEL_VISIBLE = 0x0200;
	public static final int NON_PRIVATE_TEXEL = 0x0400;
	public static final int VOLATILE_TEXEL = 0x0800;
	public static final int SIGN_EXTEND = 0x1000;
	public static final int ZERO_EXTEND = 0x2000;
	public static final int NONTEMPORAL = 0x4000;
	public static final int OFFSETS = 0x10000;

	public static int getArgumentCount(int masks) {
		int argumentCount = 0;
		argumentCount += (masks & ImageOperands.BIAS) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.LOD) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.GRAD) == 0 ? 0 : 2;
		argumentCount += (masks & ImageOperands.CONST_OFFSET) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.OFFSET) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.CONST_OFFSETS) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.SAMPLE) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.MIN_LOD) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.MAKE_TEXEL_AVAILABLE) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.MAKE_TEXEL_VISIBLE) == 0 ? 0 : 1;
		argumentCount += (masks & ImageOperands.OFFSETS) == 0 ? 0 : 1;
		return argumentCount;
	}

	public static Instruction[] loadArg(int bitmask, int[] data, int offset, Instruction[] instructions) {
		int argCount = ImageOperands.getArgumentCount(bitmask);
		Instruction[] args = new Instruction[argCount];
		int index = 0;
		if ((bitmask & ImageOperands.BIAS) != 0) {
			args[index] = instructions[data[offset]];
			index++;
		}
		if ((bitmask & ImageOperands.LOD) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.GRAD) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.CONST_OFFSET) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.OFFSET) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.CONST_OFFSETS) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.SAMPLE) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.MIN_LOD) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.MAKE_TEXEL_AVAILABLE) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.MAKE_TEXEL_VISIBLE) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & ImageOperands.OFFSETS) != 0) {
			args[index] = instructions[data[offset + index]];
		}
		return args;
	}
}