package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum FPDenormMode implements ValueEnum {
	PRESERVE(0),
	FLUSH_TO_ZERO(1);

	public static final FPDenormMode[] VALUES = FPDenormMode.values();

	public final int value;

	FPDenormMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static FPDenormMode get(int value) {
		switch (value) {
			case 0:
				return FPDenormMode.PRESERVE;
			case 1:
				return FPDenormMode.FLUSH_TO_ZERO;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}