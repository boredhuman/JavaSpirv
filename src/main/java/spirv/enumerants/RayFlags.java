package spirv.enumerants;

public class RayFlags {
	public static final int NONE_KHR = 0x0000;
	public static final int OPAQUE_KHR = 0x0001;
	public static final int NO_OPAQUE_KHR = 0x0002;
	public static final int TERMINATE_ON_FIRST_HIT_KHR = 0x0004;
	public static final int SKIP_CLOSEST_HIT_SHADER_KHR = 0x0008;
	public static final int CULL_BACK_FACING_TRIANGLES_KHR = 0x0010;
	public static final int CULL_FRONT_FACING_TRIANGLES_KHR = 0x0020;
	public static final int CULL_OPAQUE_KHR = 0x0040;
	public static final int CULL_NO_OPAQUE_KHR = 0x0080;
	public static final int SKIP_TRIANGLES_KHR = 0x0100;
	public static final int SKIP_AAB_BS_KHR = 0x0200;
	public static final int FORCE_OPACITY_MICROMAP2_STATE_EXT = 0x0400;
}