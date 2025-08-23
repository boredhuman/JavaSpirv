package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum ComponentType implements ValueEnum {
	FLOAT16NV(0),
	FLOAT32NV(1),
	FLOAT64NV(2),
	SIGNED_INT8NV(3),
	SIGNED_INT16NV(4),
	SIGNED_INT32NV(5),
	SIGNED_INT64NV(6),
	UNSIGNED_INT8NV(7),
	UNSIGNED_INT16NV(8),
	UNSIGNED_INT32NV(9),
	UNSIGNED_INT64NV(10),
	SIGNED_INT8_PACKED_NV(1000491000),
	UNSIGNED_INT8_PACKED_NV(1000491001),
	FLOAT_E4M3NV(1000491002),
	FLOAT_E5M2NV(1000491003);

	public static final ComponentType[] VALUES = ComponentType.values();

	public final int value;

	ComponentType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static ComponentType get(int value) {
		switch (value) {
			case 0:
				return ComponentType.FLOAT16NV;
			case 1:
				return ComponentType.FLOAT32NV;
			case 2:
				return ComponentType.FLOAT64NV;
			case 3:
				return ComponentType.SIGNED_INT8NV;
			case 4:
				return ComponentType.SIGNED_INT16NV;
			case 5:
				return ComponentType.SIGNED_INT32NV;
			case 6:
				return ComponentType.SIGNED_INT64NV;
			case 7:
				return ComponentType.UNSIGNED_INT8NV;
			case 8:
				return ComponentType.UNSIGNED_INT16NV;
			case 9:
				return ComponentType.UNSIGNED_INT32NV;
			case 10:
				return ComponentType.UNSIGNED_INT64NV;
			case 1000491000:
				return ComponentType.SIGNED_INT8_PACKED_NV;
			case 1000491001:
				return ComponentType.UNSIGNED_INT8_PACKED_NV;
			case 1000491002:
				return ComponentType.FLOAT_E4M3NV;
			case 1000491003:
				return ComponentType.FLOAT_E5M2NV;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}