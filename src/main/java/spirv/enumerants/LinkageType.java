package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum LinkageType implements ValueEnum {
	EXPORT(0),
	IMPORT(1),
	LINK_ONCE_ODR(2);

	public static final LinkageType[] VALUES = LinkageType.values();

	public final int value;

	LinkageType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static LinkageType get(int value) {
		switch (value) {
			case 0:
				return LinkageType.EXPORT;
			case 1:
				return LinkageType.IMPORT;
			case 2:
				return LinkageType.LINK_ONCE_ODR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}