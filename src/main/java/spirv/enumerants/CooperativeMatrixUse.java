package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum CooperativeMatrixUse implements ValueEnum {
	MATRIX_AKHR(0),
	MATRIX_BKHR(1),
	MATRIX_ACCUMULATOR_KHR(2);

	public static final CooperativeMatrixUse[] VALUES = CooperativeMatrixUse.values();

	public final int value;

	CooperativeMatrixUse(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static CooperativeMatrixUse get(int value) {
		switch (value) {
			case 0:
				return CooperativeMatrixUse.MATRIX_AKHR;
			case 1:
				return CooperativeMatrixUse.MATRIX_BKHR;
			case 2:
				return CooperativeMatrixUse.MATRIX_ACCUMULATOR_KHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}