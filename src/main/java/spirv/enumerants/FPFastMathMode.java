package spirv.enumerants;

public class FPFastMathMode {
	public static final int NONE = 0x0000;
	public static final int NOT_NA_N = 0x0001;
	public static final int NOT_INF = 0x0002;
	public static final int NSZ = 0x0004;
	public static final int ALLOW_RECIP = 0x0008;
	public static final int FAST = 0x0010;
	public static final int ALLOW_CONTRACT = 0x10000;
	public static final int ALLOW_REASSOC = 0x20000;
	public static final int ALLOW_TRANSFORM = 0x40000;
}