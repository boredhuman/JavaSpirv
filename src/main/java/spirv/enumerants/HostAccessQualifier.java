package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum HostAccessQualifier implements ValueEnum {
	NONE_INTEL(0),
	READ_INTEL(1),
	WRITE_INTEL(2),
	READ_WRITE_INTEL(3);

	public static final HostAccessQualifier[] VALUES = HostAccessQualifier.values();

	public final int value;

	HostAccessQualifier(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static HostAccessQualifier get(int value) {
		switch (value) {
			case 0:
				return HostAccessQualifier.NONE_INTEL;
			case 1:
				return HostAccessQualifier.READ_INTEL;
			case 2:
				return HostAccessQualifier.WRITE_INTEL;
			case 3:
				return HostAccessQualifier.READ_WRITE_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}