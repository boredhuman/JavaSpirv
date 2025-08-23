package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum SamplerAddressingMode implements ValueEnum {
	NONE(0),
	CLAMP_TO_EDGE(1),
	CLAMP(2),
	REPEAT(3),
	REPEAT_MIRRORED(4);

	public static final SamplerAddressingMode[] VALUES = SamplerAddressingMode.values();

	public final int value;

	SamplerAddressingMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static SamplerAddressingMode get(int value) {
		switch (value) {
			case 0:
				return SamplerAddressingMode.NONE;
			case 1:
				return SamplerAddressingMode.CLAMP_TO_EDGE;
			case 2:
				return SamplerAddressingMode.CLAMP;
			case 3:
				return SamplerAddressingMode.REPEAT;
			case 4:
				return SamplerAddressingMode.REPEAT_MIRRORED;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}