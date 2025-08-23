package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum NamedMaximumNumberOfRegisters implements ValueEnum {
	AUTO_INTEL(0);

	public static final NamedMaximumNumberOfRegisters[] VALUES = NamedMaximumNumberOfRegisters.values();

	public final int value;

	NamedMaximumNumberOfRegisters(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static NamedMaximumNumberOfRegisters get(int value) {
		switch (value) {
			case 0:
				return NamedMaximumNumberOfRegisters.AUTO_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}