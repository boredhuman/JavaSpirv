package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum KernelEnqueueFlags implements ValueEnum {
	NO_WAIT(0),
	WAIT_KERNEL(1),
	WAIT_WORK_GROUP(2);

	public static final KernelEnqueueFlags[] VALUES = KernelEnqueueFlags.values();

	public final int value;

	KernelEnqueueFlags(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static KernelEnqueueFlags get(int value) {
		switch (value) {
			case 0:
				return KernelEnqueueFlags.NO_WAIT;
			case 1:
				return KernelEnqueueFlags.WAIT_KERNEL;
			case 2:
				return KernelEnqueueFlags.WAIT_WORK_GROUP;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}