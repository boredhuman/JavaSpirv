package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum FPEncoding implements ValueEnum {
	B_FLOAT16KHR(0),
	FLOAT8E4M3EXT(4214),
	FLOAT8E5M2EXT(4215);

	public static final FPEncoding[] VALUES = FPEncoding.values();

	public final int value;

	FPEncoding(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static FPEncoding get(int value) {
		switch (value) {
			case 0:
				return FPEncoding.B_FLOAT16KHR;
			case 4214:
				return FPEncoding.FLOAT8E4M3EXT;
			case 4215:
				return FPEncoding.FLOAT8E5M2EXT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}