package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum QuantizationModes implements ValueEnum {
	TRN(0),
	TRN_ZERO(1),
	RND(2),
	RND_ZERO(3),
	RND_INF(4),
	RND_MIN_INF(5),
	RND_CONV(6),
	RND_CONV_ODD(7);

	public static final QuantizationModes[] VALUES = QuantizationModes.values();

	public final int value;

	QuantizationModes(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static QuantizationModes get(int value) {
		switch (value) {
			case 0:
				return QuantizationModes.TRN;
			case 1:
				return QuantizationModes.TRN_ZERO;
			case 2:
				return QuantizationModes.RND;
			case 3:
				return QuantizationModes.RND_ZERO;
			case 4:
				return QuantizationModes.RND_INF;
			case 5:
				return QuantizationModes.RND_MIN_INF;
			case 6:
				return QuantizationModes.RND_CONV;
			case 7:
				return QuantizationModes.RND_CONV_ODD;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}