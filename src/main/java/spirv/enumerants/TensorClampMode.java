package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum TensorClampMode implements ValueEnum {
	UNDEFINED(0),
	CONSTANT(1),
	CLAMP_TO_EDGE(2),
	REPEAT(3),
	REPEAT_MIRRORED(4);

	public static final TensorClampMode[] VALUES = TensorClampMode.values();

	public final int value;

	TensorClampMode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static TensorClampMode get(int value) {
		switch (value) {
			case 0:
				return TensorClampMode.UNDEFINED;
			case 1:
				return TensorClampMode.CONSTANT;
			case 2:
				return TensorClampMode.CLAMP_TO_EDGE;
			case 3:
				return TensorClampMode.REPEAT;
			case 4:
				return TensorClampMode.REPEAT_MIRRORED;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}