package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum AddressingModel implements ValueEnum {
	LOGICAL(0),
	PHYSICAL32(1),
	PHYSICAL64(2),
	PHYSICAL_STORAGE_BUFFER64(5348);

	public static final AddressingModel[] VALUES = AddressingModel.values();

	public final int value;

	AddressingModel(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static AddressingModel get(int value) {
		switch (value) {
			case 0:
				return AddressingModel.LOGICAL;
			case 1:
				return AddressingModel.PHYSICAL32;
			case 2:
				return AddressingModel.PHYSICAL64;
			case 5348:
				return AddressingModel.PHYSICAL_STORAGE_BUFFER64;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}