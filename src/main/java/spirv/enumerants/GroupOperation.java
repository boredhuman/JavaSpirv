package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum GroupOperation implements ValueEnum {
	REDUCE(0),
	INCLUSIVE_SCAN(1),
	EXCLUSIVE_SCAN(2),
	CLUSTERED_REDUCE(3),
	PARTITIONED_REDUCE_NV(6),
	PARTITIONED_INCLUSIVE_SCAN_NV(7),
	PARTITIONED_EXCLUSIVE_SCAN_NV(8);

	public static final GroupOperation[] VALUES = GroupOperation.values();

	public final int value;

	GroupOperation(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static GroupOperation get(int value) {
		switch (value) {
			case 0:
				return GroupOperation.REDUCE;
			case 1:
				return GroupOperation.INCLUSIVE_SCAN;
			case 2:
				return GroupOperation.EXCLUSIVE_SCAN;
			case 3:
				return GroupOperation.CLUSTERED_REDUCE;
			case 6:
				return GroupOperation.PARTITIONED_REDUCE_NV;
			case 7:
				return GroupOperation.PARTITIONED_INCLUSIVE_SCAN_NV;
			case 8:
				return GroupOperation.PARTITIONED_EXCLUSIVE_SCAN_NV;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}