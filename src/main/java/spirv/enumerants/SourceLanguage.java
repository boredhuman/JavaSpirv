package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum SourceLanguage implements ValueEnum {
	UNKNOWN(0),
	ESSL(1),
	GLSL(2),
	OPEN_CL_C(3),
	OPEN_CL_CPP(4),
	HLSL(5),
	CPP_FOR__OPEN_CL(6),
	SYCL(7),
	HERO_C(8),
	NZSL(9),
	WGSL(10),
	SLANG(11),
	ZIG(12),
	RUST(13);

	public static final SourceLanguage[] VALUES = SourceLanguage.values();

	public final int value;

	SourceLanguage(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static SourceLanguage get(int value) {
		switch (value) {
			case 0:
				return SourceLanguage.UNKNOWN;
			case 1:
				return SourceLanguage.ESSL;
			case 2:
				return SourceLanguage.GLSL;
			case 3:
				return SourceLanguage.OPEN_CL_C;
			case 4:
				return SourceLanguage.OPEN_CL_CPP;
			case 5:
				return SourceLanguage.HLSL;
			case 6:
				return SourceLanguage.CPP_FOR__OPEN_CL;
			case 7:
				return SourceLanguage.SYCL;
			case 8:
				return SourceLanguage.HERO_C;
			case 9:
				return SourceLanguage.NZSL;
			case 10:
				return SourceLanguage.WGSL;
			case 11:
				return SourceLanguage.SLANG;
			case 12:
				return SourceLanguage.ZIG;
			case 13:
				return SourceLanguage.RUST;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}