package spirv.enumerants;

import spirv.instructions.Instruction;

public class MemoryAccess {
	public static final int NONE = 0x0000;
	public static final int VOLATILE = 0x0001;
	public static final int ALIGNED = 0x0002;
	public static final int NONTEMPORAL = 0x0004;
	public static final int MAKE_POINTER_AVAILABLE = 0x0008;
	public static final int MAKE_POINTER_VISIBLE = 0x0010;
	public static final int NON_PRIVATE_POINTER = 0x0020;
	public static final int ALIAS_SCOPE_INTEL_MASK = 0x10000;
	public static final int NO_ALIAS_INTEL_MASK = 0x20000;

	public static int getArgumentCount(int masks) {
		int argumentCount = 0;
		argumentCount += (masks & MemoryAccess.ALIGNED) == 0 ? 0 : 1;
		argumentCount += (masks & MemoryAccess.MAKE_POINTER_AVAILABLE) == 0 ? 0 : 1;
		argumentCount += (masks & MemoryAccess.MAKE_POINTER_VISIBLE) == 0 ? 0 : 1;
		argumentCount += (masks & MemoryAccess.ALIAS_SCOPE_INTEL_MASK) == 0 ? 0 : 1;
		argumentCount += (masks & MemoryAccess.NO_ALIAS_INTEL_MASK) == 0 ? 0 : 1;
		return argumentCount;
	}

	public static Object[] loadArg(int bitmask, int[] data, int offset, Instruction[] instructions) {
		int argCount = MemoryAccess.getArgumentCount(bitmask);
		Object[] args = new Object[argCount];
		int index = 0;
		if ((bitmask & MemoryAccess.ALIGNED) != 0) {
			args[index] = data[offset];
			index++;
		}
		if ((bitmask & MemoryAccess.MAKE_POINTER_AVAILABLE) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & MemoryAccess.MAKE_POINTER_VISIBLE) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & MemoryAccess.ALIAS_SCOPE_INTEL_MASK) != 0) {
			args[index] = instructions[data[offset + index]];
			index++;
		}
		if ((bitmask & MemoryAccess.NO_ALIAS_INTEL_MASK) != 0) {
			args[index] = instructions[data[offset + index]];
		}
		return args;
	}
}