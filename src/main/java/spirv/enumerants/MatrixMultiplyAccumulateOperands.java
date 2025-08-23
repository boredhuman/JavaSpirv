package spirv.enumerants;

public class MatrixMultiplyAccumulateOperands {
	public static final int NONE = 0x0;
	public static final int MATRIX_A_SIGNED_COMPONENTS_INTEL = 0x1;
	public static final int MATRIX_B_SIGNED_COMPONENTS_INTEL = 0x2;
	public static final int MATRIX_CB_FLOAT16INTEL = 0x4;
	public static final int MATRIX_RESULT_B_FLOAT16INTEL = 0x8;
	public static final int MATRIX_A_PACKED_INT8INTEL = 0x10;
	public static final int MATRIX_B_PACKED_INT8INTEL = 0x20;
	public static final int MATRIX_A_PACKED_INT4INTEL = 0x40;
	public static final int MATRIX_B_PACKED_INT4INTEL = 0x80;
	public static final int MATRIX_ATF32INTEL = 0x100;
	public static final int MATRIX_BTF32INTEL = 0x200;
	public static final int MATRIX_A_PACKED_FLOAT16INTEL = 0x400;
	public static final int MATRIX_B_PACKED_FLOAT16INTEL = 0x800;
	public static final int MATRIX_A_PACKED_B_FLOAT16INTEL = 0x1000;
	public static final int MATRIX_B_PACKED_B_FLOAT16INTEL = 0x2000;
}