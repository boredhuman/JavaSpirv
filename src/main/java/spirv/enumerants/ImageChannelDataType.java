package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum ImageChannelDataType implements ValueEnum {
	SNORM_INT8(0),
	SNORM_INT16(1),
	UNORM_INT8(2),
	UNORM_INT16(3),
	UNORM_SHORT565(4),
	UNORM_SHORT555(5),
	UNORM_INT101010(6),
	SIGNED_INT8(7),
	SIGNED_INT16(8),
	SIGNED_INT32(9),
	UNSIGNED_INT8(10),
	UNSIGNED_INT16(11),
	UNSIGNED_INT32(12),
	HALF_FLOAT(13),
	FLOAT(14),
	UNORM_INT24(15),
	UNORM_INT101010_2(16),
	UNORM_INT10X6EXT(17),
	UNSIGNED_INT_RAW10EXT(19),
	UNSIGNED_INT_RAW12EXT(20),
	UNORM_INT2_101010EXT(21),
	UNSIGNED_INT10X6EXT(22),
	UNSIGNED_INT12X4EXT(23),
	UNSIGNED_INT14X2EXT(24),
	UNORM_INT12X4EXT(25),
	UNORM_INT14X2EXT(26);

	public static final ImageChannelDataType[] VALUES = ImageChannelDataType.values();

	public final int value;

	ImageChannelDataType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static ImageChannelDataType get(int value) {
		switch (value) {
			case 0:
				return ImageChannelDataType.SNORM_INT8;
			case 1:
				return ImageChannelDataType.SNORM_INT16;
			case 2:
				return ImageChannelDataType.UNORM_INT8;
			case 3:
				return ImageChannelDataType.UNORM_INT16;
			case 4:
				return ImageChannelDataType.UNORM_SHORT565;
			case 5:
				return ImageChannelDataType.UNORM_SHORT555;
			case 6:
				return ImageChannelDataType.UNORM_INT101010;
			case 7:
				return ImageChannelDataType.SIGNED_INT8;
			case 8:
				return ImageChannelDataType.SIGNED_INT16;
			case 9:
				return ImageChannelDataType.SIGNED_INT32;
			case 10:
				return ImageChannelDataType.UNSIGNED_INT8;
			case 11:
				return ImageChannelDataType.UNSIGNED_INT16;
			case 12:
				return ImageChannelDataType.UNSIGNED_INT32;
			case 13:
				return ImageChannelDataType.HALF_FLOAT;
			case 14:
				return ImageChannelDataType.FLOAT;
			case 15:
				return ImageChannelDataType.UNORM_INT24;
			case 16:
				return ImageChannelDataType.UNORM_INT101010_2;
			case 17:
				return ImageChannelDataType.UNORM_INT10X6EXT;
			case 19:
				return ImageChannelDataType.UNSIGNED_INT_RAW10EXT;
			case 20:
				return ImageChannelDataType.UNSIGNED_INT_RAW12EXT;
			case 21:
				return ImageChannelDataType.UNORM_INT2_101010EXT;
			case 22:
				return ImageChannelDataType.UNSIGNED_INT10X6EXT;
			case 23:
				return ImageChannelDataType.UNSIGNED_INT12X4EXT;
			case 24:
				return ImageChannelDataType.UNSIGNED_INT14X2EXT;
			case 25:
				return ImageChannelDataType.UNORM_INT12X4EXT;
			case 26:
				return ImageChannelDataType.UNORM_INT14X2EXT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}