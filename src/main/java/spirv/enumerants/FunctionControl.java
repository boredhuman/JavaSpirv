package spirv.enumerants;

public class FunctionControl {
	public static final int NONE = 0x0000;
	public static final int INLINE = 0x0001;
	public static final int DONT_INLINE = 0x0002;
	public static final int PURE = 0x0004;
	public static final int CONST = 0x0008;
	public static final int OPT_NONE_EXT = 0x10000;
}