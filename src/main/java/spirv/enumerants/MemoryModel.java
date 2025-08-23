package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum MemoryModel implements ValueEnum {
	SIMPLE(0),
	GLSL450(1),
	OPEN_CL(2),
	VULKAN(3);

	public static final MemoryModel[] VALUES = MemoryModel.values();

	public final int value;

	MemoryModel(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static MemoryModel get(int value) {
		switch (value) {
			case 0:
				return MemoryModel.SIMPLE;
			case 1:
				return MemoryModel.GLSL450;
			case 2:
				return MemoryModel.OPEN_CL;
			case 3:
				return MemoryModel.VULKAN;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}