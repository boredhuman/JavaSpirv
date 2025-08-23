package spirv.enumerants;

import spirv.instructions.Instruction;

public class TensorAddressingOperands {
	public static final int NONE = 0x0000;
	public static final int TENSOR_VIEW = 0x0001;
	public static final int DECODE_FUNC = 0x0002;

	public static int getArgumentCount(int masks) {
		int argumentCount = 0;
		argumentCount += (masks & TensorAddressingOperands.TENSOR_VIEW) == 0 ? 0 : 1;
		argumentCount += (masks & TensorAddressingOperands.DECODE_FUNC) == 0 ? 0 : 1;
		return argumentCount;
	}

	public static Instruction[] loadArg(int bitmask, int[] data, int offset, Instruction[] instructions) {
		int argCount = TensorAddressingOperands.getArgumentCount(bitmask);
		Instruction[] args = new Instruction[argCount];
		int index = 0;
		if ((bitmask & TensorAddressingOperands.TENSOR_VIEW) != 0) {
			args[index] = instructions[data[offset]];
			index++;
		}
		if ((bitmask & TensorAddressingOperands.DECODE_FUNC) != 0) {
			args[index] = instructions[data[offset + index]];
		}
		return args;
	}
}