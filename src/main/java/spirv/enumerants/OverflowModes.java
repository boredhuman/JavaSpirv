package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum OverflowModes implements ValueEnum {
	WRAP(0),
	SAT(1),
	SAT_ZERO(2),
	SAT_SYM(3);

	public static final OverflowModes[] VALUES = OverflowModes.values();

	public final int value;

	OverflowModes(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static OverflowModes get(int value) {
		switch (value) {
			case 0:
				return OverflowModes.WRAP;
			case 1:
				return OverflowModes.SAT;
			case 2:
				return OverflowModes.SAT_ZERO;
			case 3:
				return OverflowModes.SAT_SYM;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}