package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum CooperativeVectorMatrixLayout implements ValueEnum {
	ROW_MAJOR_NV(0),
	COLUMN_MAJOR_NV(1),
	INFERENCING_OPTIMAL_NV(2),
	TRAINING_OPTIMAL_NV(3);

	public static final CooperativeVectorMatrixLayout[] VALUES = CooperativeVectorMatrixLayout.values();

	public final int value;

	CooperativeVectorMatrixLayout(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static CooperativeVectorMatrixLayout get(int value) {
		switch (value) {
			case 0:
				return CooperativeVectorMatrixLayout.ROW_MAJOR_NV;
			case 1:
				return CooperativeVectorMatrixLayout.COLUMN_MAJOR_NV;
			case 2:
				return CooperativeVectorMatrixLayout.INFERENCING_OPTIMAL_NV;
			case 3:
				return CooperativeVectorMatrixLayout.TRAINING_OPTIMAL_NV;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}