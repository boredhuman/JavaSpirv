package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum Scope implements ValueEnum {
	CROSS_DEVICE(0),
	DEVICE(1),
	WORKGROUP(2),
	SUBGROUP(3),
	INVOCATION(4),
	QUEUE_FAMILY(5),
	SHADER_CALL_KHR(6);

	public static final Scope[] VALUES = Scope.values();

	public final int value;

	Scope(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static Scope get(int value) {
		switch (value) {
			case 0:
				return Scope.CROSS_DEVICE;
			case 1:
				return Scope.DEVICE;
			case 2:
				return Scope.WORKGROUP;
			case 3:
				return Scope.SUBGROUP;
			case 4:
				return Scope.INVOCATION;
			case 5:
				return Scope.QUEUE_FAMILY;
			case 6:
				return Scope.SHADER_CALL_KHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}