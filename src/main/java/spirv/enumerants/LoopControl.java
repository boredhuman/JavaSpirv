package spirv.enumerants;

import spirv.instructions.Instruction;

public class LoopControl {
	public static final int NONE = 0x0000;
	public static final int UNROLL = 0x0001;
	public static final int DONT_UNROLL = 0x0002;
	public static final int DEPENDENCY_INFINITE = 0x0004;
	public static final int DEPENDENCY_LENGTH = 0x0008;
	public static final int MIN_ITERATIONS = 0x0010;
	public static final int MAX_ITERATIONS = 0x0020;
	public static final int ITERATION_MULTIPLE = 0x0040;
	public static final int PEEL_COUNT = 0x0080;
	public static final int PARTIAL_COUNT = 0x0100;
	public static final int INITIATION_INTERVAL_INTEL = 0x10000;
	public static final int MAX_CONCURRENCY_INTEL = 0x20000;
	public static final int DEPENDENCY_ARRAY_INTEL = 0x40000;
	public static final int PIPELINE_ENABLE_INTEL = 0x80000;
	public static final int LOOP_COALESCE_INTEL = 0x100000;
	public static final int MAX_INTERLEAVING_INTEL = 0x200000;
	public static final int SPECULATED_ITERATIONS_INTEL = 0x400000;
	public static final int NO_FUSION_INTEL = 0x800000;
	public static final int LOOP_COUNT_INTEL = 0x1000000;
	public static final int MAX_REINVOCATION_DELAY_INTEL = 0x2000000;

	public static int getArgumentCount(int masks) {
		int argumentCount = 0;
		argumentCount += (masks & LoopControl.DEPENDENCY_LENGTH) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.MIN_ITERATIONS) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.MAX_ITERATIONS) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.ITERATION_MULTIPLE) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.PEEL_COUNT) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.PARTIAL_COUNT) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.INITIATION_INTERVAL_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.MAX_CONCURRENCY_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.DEPENDENCY_ARRAY_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.PIPELINE_ENABLE_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.LOOP_COALESCE_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.MAX_INTERLEAVING_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.SPECULATED_ITERATIONS_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.LOOP_COUNT_INTEL) == 0 ? 0 : 1;
		argumentCount += (masks & LoopControl.MAX_REINVOCATION_DELAY_INTEL) == 0 ? 0 : 1;
		return argumentCount;
	}

	public static int[] loadArg(int bitmask, int[] data, int offset, Instruction[] instructions) {
		int argCount = LoopControl.getArgumentCount(bitmask);
		int[] args = new int[argCount];
		int index = 0;
		if ((bitmask & LoopControl.DEPENDENCY_LENGTH) != 0) {
			args[index] = data[offset];
			index++;
		}
		if ((bitmask & LoopControl.MIN_ITERATIONS) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.MAX_ITERATIONS) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.ITERATION_MULTIPLE) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.PEEL_COUNT) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.PARTIAL_COUNT) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.INITIATION_INTERVAL_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.MAX_CONCURRENCY_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.DEPENDENCY_ARRAY_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.PIPELINE_ENABLE_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.LOOP_COALESCE_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.MAX_INTERLEAVING_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.SPECULATED_ITERATIONS_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.LOOP_COUNT_INTEL) != 0) {
			args[index] = data[offset + index];
			index++;
		}
		if ((bitmask & LoopControl.MAX_REINVOCATION_DELAY_INTEL) != 0) {
			args[index] = data[offset + index];
		}
		return args;
	}
}