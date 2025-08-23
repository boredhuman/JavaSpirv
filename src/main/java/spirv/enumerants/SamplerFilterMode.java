package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum SamplerFilterMode implements ValueEnum {
	NEAREST(0),
	LINEAR(1);

	public static final SamplerFilterMode[] VALUES = SamplerFilterMode.values();

	public final int value;

	SamplerFilterMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static SamplerFilterMode get(int value) {
		switch (value) {
			case 0:
				return SamplerFilterMode.NEAREST;
			case 1:
				return SamplerFilterMode.LINEAR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}