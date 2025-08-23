package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum FunctionParameterAttribute implements ValueEnum {
	ZEXT(0),
	SEXT(1),
	BY_VAL(2),
	SRET(3),
	NO_ALIAS(4),
	NO_CAPTURE(5),
	NO_WRITE(6),
	NO_READ_WRITE(7),
	RUNTIME_ALIGNED_INTEL(5940);

	public static final FunctionParameterAttribute[] VALUES = FunctionParameterAttribute.values();

	public final int value;

	FunctionParameterAttribute(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static FunctionParameterAttribute get(int value) {
		switch (value) {
			case 0:
				return FunctionParameterAttribute.ZEXT;
			case 1:
				return FunctionParameterAttribute.SEXT;
			case 2:
				return FunctionParameterAttribute.BY_VAL;
			case 3:
				return FunctionParameterAttribute.SRET;
			case 4:
				return FunctionParameterAttribute.NO_ALIAS;
			case 5:
				return FunctionParameterAttribute.NO_CAPTURE;
			case 6:
				return FunctionParameterAttribute.NO_WRITE;
			case 7:
				return FunctionParameterAttribute.NO_READ_WRITE;
			case 5940:
				return FunctionParameterAttribute.RUNTIME_ALIGNED_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}