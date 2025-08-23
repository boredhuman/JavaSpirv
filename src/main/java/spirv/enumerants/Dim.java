package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum Dim implements ValueEnum {
	DIM_1D(0),
	DIM_2D(1),
	DIM_3D(2),
	CUBE(3),
	RECT(4),
	BUFFER(5),
	SUBPASS_DATA(6),
	TILE_IMAGE_DATA_EXT(4173);

	public static final Dim[] VALUES = Dim.values();

	public final int value;

	Dim(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static Dim get(int value) {
		switch (value) {
			case 0:
				return Dim.DIM_1D;
			case 1:
				return Dim.DIM_2D;
			case 2:
				return Dim.DIM_3D;
			case 3:
				return Dim.CUBE;
			case 4:
				return Dim.RECT;
			case 5:
				return Dim.BUFFER;
			case 6:
				return Dim.SUBPASS_DATA;
			case 4173:
				return Dim.TILE_IMAGE_DATA_EXT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}