package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum CooperativeMatrixLayout implements ValueEnum {
	ROW_MAJOR_KHR(0),
	COLUMN_MAJOR_KHR(1),
	ROW_BLOCKED_INTERLEAVED_ARM(4202),
	COLUMN_BLOCKED_INTERLEAVED_ARM(4203);

	public static final CooperativeMatrixLayout[] VALUES = CooperativeMatrixLayout.values();

	public final int value;

	CooperativeMatrixLayout(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static CooperativeMatrixLayout get(int value) {
		switch (value) {
			case 0:
				return CooperativeMatrixLayout.ROW_MAJOR_KHR;
			case 1:
				return CooperativeMatrixLayout.COLUMN_MAJOR_KHR;
			case 4202:
				return CooperativeMatrixLayout.ROW_BLOCKED_INTERLEAVED_ARM;
			case 4203:
				return CooperativeMatrixLayout.COLUMN_BLOCKED_INTERLEAVED_ARM;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}