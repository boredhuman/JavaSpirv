package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum PackedVectorFormat implements ValueEnum {
	PACKED_VECTOR_FORMAT4X8_BIT(0);

	public static final PackedVectorFormat[] VALUES = PackedVectorFormat.values();

	public final int value;

	PackedVectorFormat(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static PackedVectorFormat get(int value) {
		switch (value) {
			case 0:
				return PackedVectorFormat.PACKED_VECTOR_FORMAT4X8_BIT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}