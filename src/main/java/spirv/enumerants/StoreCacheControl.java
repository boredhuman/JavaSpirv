package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum StoreCacheControl implements ValueEnum {
	UNCACHED_INTEL(0),
	WRITE_THROUGH_INTEL(1),
	WRITE_BACK_INTEL(2),
	STREAMING_INTEL(3);

	public static final StoreCacheControl[] VALUES = StoreCacheControl.values();

	public final int value;

	StoreCacheControl(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static StoreCacheControl get(int value) {
		switch (value) {
			case 0:
				return StoreCacheControl.UNCACHED_INTEL;
			case 1:
				return StoreCacheControl.WRITE_THROUGH_INTEL;
			case 2:
				return StoreCacheControl.WRITE_BACK_INTEL;
			case 3:
				return StoreCacheControl.STREAMING_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}