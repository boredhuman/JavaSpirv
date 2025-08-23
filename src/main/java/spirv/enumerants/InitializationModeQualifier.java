package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum InitializationModeQualifier implements ValueEnum {
	INIT_ON_DEVICE_REPROGRAM_INTEL(0),
	INIT_ON_DEVICE_RESET_INTEL(1);

	public static final InitializationModeQualifier[] VALUES = InitializationModeQualifier.values();

	public final int value;

	InitializationModeQualifier(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static InitializationModeQualifier get(int value) {
		switch (value) {
			case 0:
				return InitializationModeQualifier.INIT_ON_DEVICE_REPROGRAM_INTEL;
			case 1:
				return InitializationModeQualifier.INIT_ON_DEVICE_RESET_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}