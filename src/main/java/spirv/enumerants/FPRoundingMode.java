package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum FPRoundingMode implements ValueEnum {
	RTE(0),
	RTZ(1),
	RTP(2),
	RTN(3);

	public static final FPRoundingMode[] VALUES = FPRoundingMode.values();

	public final int value;

	FPRoundingMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static FPRoundingMode get(int value) {
		switch (value) {
			case 0:
				return FPRoundingMode.RTE;
			case 1:
				return FPRoundingMode.RTZ;
			case 2:
				return FPRoundingMode.RTP;
			case 3:
				return FPRoundingMode.RTN;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}