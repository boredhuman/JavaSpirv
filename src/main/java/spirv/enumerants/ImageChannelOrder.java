package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum ImageChannelOrder implements ValueEnum {
	R(0),
	A(1),
	RG(2),
	RA(3),
	RGB(4),
	RGBA(5),
	BGRA(6),
	ARGB(7),
	INTENSITY(8),
	LUMINANCE(9),
	RX(10),
	R_GX(11),
	RG_BX(12),
	DEPTH(13),
	DEPTH_STENCIL(14),
	S_RGB(15),
	S_RG_BX(16),
	S_RGBA(17),
	S_BGRA(18),
	ABGR(19);

	public static final ImageChannelOrder[] VALUES = ImageChannelOrder.values();

	public final int value;

	ImageChannelOrder(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static ImageChannelOrder get(int value) {
		switch (value) {
			case 0:
				return ImageChannelOrder.R;
			case 1:
				return ImageChannelOrder.A;
			case 2:
				return ImageChannelOrder.RG;
			case 3:
				return ImageChannelOrder.RA;
			case 4:
				return ImageChannelOrder.RGB;
			case 5:
				return ImageChannelOrder.RGBA;
			case 6:
				return ImageChannelOrder.BGRA;
			case 7:
				return ImageChannelOrder.ARGB;
			case 8:
				return ImageChannelOrder.INTENSITY;
			case 9:
				return ImageChannelOrder.LUMINANCE;
			case 10:
				return ImageChannelOrder.RX;
			case 11:
				return ImageChannelOrder.R_GX;
			case 12:
				return ImageChannelOrder.RG_BX;
			case 13:
				return ImageChannelOrder.DEPTH;
			case 14:
				return ImageChannelOrder.DEPTH_STENCIL;
			case 15:
				return ImageChannelOrder.S_RGB;
			case 16:
				return ImageChannelOrder.S_RG_BX;
			case 17:
				return ImageChannelOrder.S_RGBA;
			case 18:
				return ImageChannelOrder.S_BGRA;
			case 19:
				return ImageChannelOrder.ABGR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}