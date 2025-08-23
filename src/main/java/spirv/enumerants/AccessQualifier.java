package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum AccessQualifier implements ValueEnum {
	READ_ONLY(0),
	WRITE_ONLY(1),
	READ_WRITE(2);

	public static final AccessQualifier[] VALUES = AccessQualifier.values();

	public final int value;

	AccessQualifier(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static AccessQualifier get(int value) {
		switch (value) {
			case 0:
				return AccessQualifier.READ_ONLY;
			case 1:
				return AccessQualifier.WRITE_ONLY;
			case 2:
				return AccessQualifier.READ_WRITE;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}