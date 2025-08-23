package spirv.enumerants;

import spirv.instructions.Instruction;

public class TensorOperands {
	public static final int NONE_ARM = 0x0000;
	public static final int NONTEMPORAL_ARM = 0x0001;
	public static final int OUT_OF_BOUNDS_VALUE_ARM = 0x0002;
	public static final int MAKE_ELEMENT_AVAILABLE_ARM = 0x0004;
	public static final int MAKE_ELEMENT_VISIBLE_ARM = 0x0008;
	public static final int NON_PRIVATE_ELEMENT_ARM = 0x0010;

	public static int getArgumentCount(int masks) {
		int argumentCount = 0;
		argumentCount += (masks & TensorOperands.OUT_OF_BOUNDS_VALUE_ARM) == 0 ? 0 : 1;
		argumentCount += (masks & TensorOperands.MAKE_ELEMENT_AVAILABLE_ARM) == 0 ? 0 : 1;
		argumentCount += (masks & TensorOperands.MAKE_ELEMENT_VISIBLE_ARM) == 0 ? 0 : 1;
		return argumentCount;
	}

	public static Instruction[] loadArg(int bitmask, int[] data, int offset, Instruction[] instructions) {
		int argCount = TensorOperands.getArgumentCount(bitmask);
		Instruction[] args = new Instruction[argCount];
		int index = 0;
		if ((bitmask & TensorOperands.OUT_OF_BOUNDS_VALUE_ARM) != 0) {
			args[index] = instructions[data[offset]];
			index++;
		}
		if ((bitmask & TensorOperands.MAKE_ELEMENT_AVAILABLE_ARM) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & TensorOperands.MAKE_ELEMENT_VISIBLE_ARM) != 0) {
			args[index] = instructions[data[offset + index]];
		}
		return args;
	}
}