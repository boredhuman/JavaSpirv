package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum ImageFormat implements ValueEnum {
	UNKNOWN(0),
	RGBA32F(1),
	RGBA16F(2),
	R32F(3),
	RGBA8(4),
	RGBA8_SNORM(5),
	RG32F(6),
	RG16F(7),
	R11F_G11F_B10F(8),
	R16F(9),
	RGBA16(10),
	RGB10A2(11),
	RG16(12),
	RG8(13),
	R16(14),
	R8(15),
	RGBA16_SNORM(16),
	RG16_SNORM(17),
	RG8_SNORM(18),
	R16_SNORM(19),
	R8_SNORM(20),
	RGBA32I(21),
	RGBA16I(22),
	RGBA8I(23),
	R32I(24),
	RG32I(25),
	RG16I(26),
	RG8I(27),
	R16I(28),
	R8I(29),
	RGBA32UI(30),
	RGBA16UI(31),
	RGBA8UI(32),
	R32UI(33),
	RGB10A2UI(34),
	RG32UI(35),
	RG16UI(36),
	RG8UI(37),
	R16UI(38),
	R8UI(39),
	R64UI(40),
	R64I(41);

	public static final ImageFormat[] VALUES = ImageFormat.values();

	public final int value;

	ImageFormat(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static ImageFormat get(int value) {
		switch (value) {
			case 0:
				return ImageFormat.UNKNOWN;
			case 1:
				return ImageFormat.RGBA32F;
			case 2:
				return ImageFormat.RGBA16F;
			case 3:
				return ImageFormat.R32F;
			case 4:
				return ImageFormat.RGBA8;
			case 5:
				return ImageFormat.RGBA8_SNORM;
			case 6:
				return ImageFormat.RG32F;
			case 7:
				return ImageFormat.RG16F;
			case 8:
				return ImageFormat.R11F_G11F_B10F;
			case 9:
				return ImageFormat.R16F;
			case 10:
				return ImageFormat.RGBA16;
			case 11:
				return ImageFormat.RGB10A2;
			case 12:
				return ImageFormat.RG16;
			case 13:
				return ImageFormat.RG8;
			case 14:
				return ImageFormat.R16;
			case 15:
				return ImageFormat.R8;
			case 16:
				return ImageFormat.RGBA16_SNORM;
			case 17:
				return ImageFormat.RG16_SNORM;
			case 18:
				return ImageFormat.RG8_SNORM;
			case 19:
				return ImageFormat.R16_SNORM;
			case 20:
				return ImageFormat.R8_SNORM;
			case 21:
				return ImageFormat.RGBA32I;
			case 22:
				return ImageFormat.RGBA16I;
			case 23:
				return ImageFormat.RGBA8I;
			case 24:
				return ImageFormat.R32I;
			case 25:
				return ImageFormat.RG32I;
			case 26:
				return ImageFormat.RG16I;
			case 27:
				return ImageFormat.RG8I;
			case 28:
				return ImageFormat.R16I;
			case 29:
				return ImageFormat.R8I;
			case 30:
				return ImageFormat.RGBA32UI;
			case 31:
				return ImageFormat.RGBA16UI;
			case 32:
				return ImageFormat.RGBA8UI;
			case 33:
				return ImageFormat.R32UI;
			case 34:
				return ImageFormat.RGB10A2UI;
			case 35:
				return ImageFormat.RG32UI;
			case 36:
				return ImageFormat.RG16UI;
			case 37:
				return ImageFormat.RG8UI;
			case 38:
				return ImageFormat.R16UI;
			case 39:
				return ImageFormat.R8UI;
			case 40:
				return ImageFormat.R64UI;
			case 41:
				return ImageFormat.R64I;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}