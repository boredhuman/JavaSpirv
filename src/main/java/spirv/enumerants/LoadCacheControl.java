package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum LoadCacheControl implements ValueEnum {
	UNCACHED_INTEL(0),
	CACHED_INTEL(1),
	STREAMING_INTEL(2),
	INVALIDATE_AFTER_READ_INTEL(3),
	CONST_CACHED_INTEL(4);

	public static final LoadCacheControl[] VALUES = LoadCacheControl.values();

	public final int value;

	LoadCacheControl(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static LoadCacheControl get(int value) {
		switch (value) {
			case 0:
				return LoadCacheControl.UNCACHED_INTEL;
			case 1:
				return LoadCacheControl.CACHED_INTEL;
			case 2:
				return LoadCacheControl.STREAMING_INTEL;
			case 3:
				return LoadCacheControl.INVALIDATE_AFTER_READ_INTEL;
			case 4:
				return LoadCacheControl.CONST_CACHED_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}