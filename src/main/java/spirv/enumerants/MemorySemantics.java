package spirv.enumerants;

public class MemorySemantics {
	public static final int RELAXED = 0x0000;
	public static final int ACQUIRE = 0x0002;
	public static final int RELEASE = 0x0004;
	public static final int ACQUIRE_RELEASE = 0x0008;
	public static final int SEQUENTIALLY_CONSISTENT = 0x0010;
	public static final int UNIFORM_MEMORY = 0x0040;
	public static final int SUBGROUP_MEMORY = 0x0080;
	public static final int WORKGROUP_MEMORY = 0x0100;
	public static final int CROSS_WORKGROUP_MEMORY = 0x0200;
	public static final int ATOMIC_COUNTER_MEMORY = 0x0400;
	public static final int IMAGE_MEMORY = 0x0800;
	public static final int OUTPUT_MEMORY = 0x1000;
	public static final int MAKE_AVAILABLE = 0x2000;
	public static final int MAKE_VISIBLE = 0x4000;
	public static final int VOLATILE = 0x8000;
}