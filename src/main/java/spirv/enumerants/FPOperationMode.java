package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum FPOperationMode implements ValueEnum {
	IEEE(0),
	ALT(1);

	public static final FPOperationMode[] VALUES = FPOperationMode.values();

	public final int value;

	FPOperationMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static FPOperationMode get(int value) {
		switch (value) {
			case 0:
				return FPOperationMode.IEEE;
			case 1:
				return FPOperationMode.ALT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}