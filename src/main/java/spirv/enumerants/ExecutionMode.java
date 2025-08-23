package spirv.enumerants;

import spirv.instructions.ValueEnum;
import spirv.instructions.Instruction;

public enum ExecutionMode implements ValueEnum {
	INVOCATIONS(0, 1),
	SPACING_EQUAL(1, 0),
	SPACING_FRACTIONAL_EVEN(2, 0),
	SPACING_FRACTIONAL_ODD(3, 0),
	VERTEX_ORDER_CW(4, 0),
	VERTEX_ORDER_CCW(5, 0),
	PIXEL_CENTER_INTEGER(6, 0),
	ORIGIN_UPPER_LEFT(7, 0),
	ORIGIN_LOWER_LEFT(8, 0),
	EARLY_FRAGMENT_TESTS(9, 0),
	POINT_MODE(10, 0),
	XFB(11, 0),
	DEPTH_REPLACING(12, 0),
	DEPTH_GREATER(14, 0),
	DEPTH_LESS(15, 0),
	DEPTH_UNCHANGED(16, 0),
	LOCAL_SIZE(17, 3),
	LOCAL_SIZE_HINT(18, 3),
	INPUT_POINTS(19, 0),
	INPUT_LINES(20, 0),
	INPUT_LINES_ADJACENCY(21, 0),
	TRIANGLES(22, 0),
	INPUT_TRIANGLES_ADJACENCY(23, 0),
	QUADS(24, 0),
	ISOLINES(25, 0),
	OUTPUT_VERTICES(26, 1),
	OUTPUT_POINTS(27, 0),
	OUTPUT_LINE_STRIP(28, 0),
	OUTPUT_TRIANGLE_STRIP(29, 0),
	VEC_TYPE_HINT(30, 1),
	CONTRACTION_OFF(31, 0),
	INITIALIZER(33, 0),
	FINALIZER(34, 0),
	SUBGROUP_SIZE(35, 1),
	SUBGROUPS_PER_WORKGROUP(36, 1),
	SUBGROUPS_PER_WORKGROUP_ID(37, 1),
	LOCAL_SIZE_ID(38, 3),
	LOCAL_SIZE_HINT_ID(39, 3),
	NON_COHERENT_COLOR_ATTACHMENT_READ_EXT(4169, 0),
	NON_COHERENT_DEPTH_ATTACHMENT_READ_EXT(4170, 0),
	NON_COHERENT_STENCIL_ATTACHMENT_READ_EXT(4171, 0),
	SUBGROUP_UNIFORM_CONTROL_FLOW_KHR(4421, 0),
	POST_DEPTH_COVERAGE(4446, 0),
	DENORM_PRESERVE(4459, 1),
	DENORM_FLUSH_TO_ZERO(4460, 1),
	SIGNED_ZERO_INF_NAN_PRESERVE(4461, 1),
	ROUNDING_MODE_RTE(4462, 1),
	ROUNDING_MODE_RTZ(4463, 1),
	NON_COHERENT_TILE_ATTACHMENT_READ_QCOM(4489, 0),
	TILE_SHADING_RATE_QCOM(4490, 3),
	EARLY_AND_LATE_FRAGMENT_TESTS_AMD(5017, 0),
	STENCIL_REF_REPLACING_EXT(5027, 0),
	COALESCING_AMDX(5069, 0),
	IS_API_ENTRY_AMDX(5070, 1),
	MAX_NODE_RECURSION_AMDX(5071, 1),
	STATIC_NUM_WORKGROUPS_AMDX(5072, 3),
	SHADER_INDEX_AMDX(5073, 1),
	MAX_NUM_WORKGROUPS_AMDX(5077, 3),
	STENCIL_REF_UNCHANGED_FRONT_AMD(5079, 0),
	STENCIL_REF_GREATER_FRONT_AMD(5080, 0),
	STENCIL_REF_LESS_FRONT_AMD(5081, 0),
	STENCIL_REF_UNCHANGED_BACK_AMD(5082, 0),
	STENCIL_REF_GREATER_BACK_AMD(5083, 0),
	STENCIL_REF_LESS_BACK_AMD(5084, 0),
	QUAD_DERIVATIVES_KHR(5088, 0),
	REQUIRE_FULL_QUADS_KHR(5089, 0),
	SHARES_INPUT_WITH_AMDX(5102, 2),
	OUTPUT_LINES_EXT(5269, 0),
	OUTPUT_PRIMITIVES_EXT(5270, 1),
	DERIVATIVE_GROUP_QUADS_KHR(5289, 0),
	DERIVATIVE_GROUP_LINEAR_KHR(5290, 0),
	OUTPUT_TRIANGLES_EXT(5298, 0),
	PIXEL_INTERLOCK_ORDERED_EXT(5366, 0),
	PIXEL_INTERLOCK_UNORDERED_EXT(5367, 0),
	SAMPLE_INTERLOCK_ORDERED_EXT(5368, 0),
	SAMPLE_INTERLOCK_UNORDERED_EXT(5369, 0),
	SHADING_RATE_INTERLOCK_ORDERED_EXT(5370, 0),
	SHADING_RATE_INTERLOCK_UNORDERED_EXT(5371, 0),
	SHARED_LOCAL_MEMORY_SIZE_INTEL(5618, 1),
	ROUNDING_MODE_RTPINTEL(5620, 1),
	ROUNDING_MODE_RTNINTEL(5621, 1),
	FLOATING_POINT_MODE_ALTINTEL(5622, 1),
	FLOATING_POINT_MODE_IEEEINTEL(5623, 1),
	MAX_WORKGROUP_SIZE_INTEL(5893, 3),
	MAX_WORK_DIM_INTEL(5894, 1),
	NO_GLOBAL_OFFSET_INTEL(5895, 0),
	NUM_SIMD_WORKITEMS_INTEL(5896, 1),
	SCHEDULER_TARGET_FMAX_MHZ_INTEL(5903, 1),
	MAXIMALLY_RECONVERGES_KHR(6023, 0),
	FP_FAST_MATH_DEFAULT(6028, 2),
	STREAMING_INTERFACE_INTEL(6154, 1),
	REGISTER_MAP_INTERFACE_INTEL(6160, 1),
	NAMED_BARRIER_COUNT_INTEL(6417, 1),
	MAXIMUM_REGISTERS_INTEL(6461, 1),
	MAXIMUM_REGISTERS_ID_INTEL(6462, 1),
	NAMED_MAXIMUM_REGISTERS_INTEL(6463, 1);

	public static final ExecutionMode[] VALUES = ExecutionMode.values();

	public final int value;
	public final int argumentCount;

	ExecutionMode(int value, int argumentCount) {
		this.value = value;
		this.argumentCount = argumentCount;
	}

	public int value() {
		return this.value;
	}

	public static ExecutionMode get(int value) {
		switch (value) {
			case 0:
				return ExecutionMode.INVOCATIONS;
			case 1:
				return ExecutionMode.SPACING_EQUAL;
			case 2:
				return ExecutionMode.SPACING_FRACTIONAL_EVEN;
			case 3:
				return ExecutionMode.SPACING_FRACTIONAL_ODD;
			case 4:
				return ExecutionMode.VERTEX_ORDER_CW;
			case 5:
				return ExecutionMode.VERTEX_ORDER_CCW;
			case 6:
				return ExecutionMode.PIXEL_CENTER_INTEGER;
			case 7:
				return ExecutionMode.ORIGIN_UPPER_LEFT;
			case 8:
				return ExecutionMode.ORIGIN_LOWER_LEFT;
			case 9:
				return ExecutionMode.EARLY_FRAGMENT_TESTS;
			case 10:
				return ExecutionMode.POINT_MODE;
			case 11:
				return ExecutionMode.XFB;
			case 12:
				return ExecutionMode.DEPTH_REPLACING;
			case 14:
				return ExecutionMode.DEPTH_GREATER;
			case 15:
				return ExecutionMode.DEPTH_LESS;
			case 16:
				return ExecutionMode.DEPTH_UNCHANGED;
			case 17:
				return ExecutionMode.LOCAL_SIZE;
			case 18:
				return ExecutionMode.LOCAL_SIZE_HINT;
			case 19:
				return ExecutionMode.INPUT_POINTS;
			case 20:
				return ExecutionMode.INPUT_LINES;
			case 21:
				return ExecutionMode.INPUT_LINES_ADJACENCY;
			case 22:
				return ExecutionMode.TRIANGLES;
			case 23:
				return ExecutionMode.INPUT_TRIANGLES_ADJACENCY;
			case 24:
				return ExecutionMode.QUADS;
			case 25:
				return ExecutionMode.ISOLINES;
			case 26:
				return ExecutionMode.OUTPUT_VERTICES;
			case 27:
				return ExecutionMode.OUTPUT_POINTS;
			case 28:
				return ExecutionMode.OUTPUT_LINE_STRIP;
			case 29:
				return ExecutionMode.OUTPUT_TRIANGLE_STRIP;
			case 30:
				return ExecutionMode.VEC_TYPE_HINT;
			case 31:
				return ExecutionMode.CONTRACTION_OFF;
			case 33:
				return ExecutionMode.INITIALIZER;
			case 34:
				return ExecutionMode.FINALIZER;
			case 35:
				return ExecutionMode.SUBGROUP_SIZE;
			case 36:
				return ExecutionMode.SUBGROUPS_PER_WORKGROUP;
			case 37:
				return ExecutionMode.SUBGROUPS_PER_WORKGROUP_ID;
			case 38:
				return ExecutionMode.LOCAL_SIZE_ID;
			case 39:
				return ExecutionMode.LOCAL_SIZE_HINT_ID;
			case 4169:
				return ExecutionMode.NON_COHERENT_COLOR_ATTACHMENT_READ_EXT;
			case 4170:
				return ExecutionMode.NON_COHERENT_DEPTH_ATTACHMENT_READ_EXT;
			case 4171:
				return ExecutionMode.NON_COHERENT_STENCIL_ATTACHMENT_READ_EXT;
			case 4421:
				return ExecutionMode.SUBGROUP_UNIFORM_CONTROL_FLOW_KHR;
			case 4446:
				return ExecutionMode.POST_DEPTH_COVERAGE;
			case 4459:
				return ExecutionMode.DENORM_PRESERVE;
			case 4460:
				return ExecutionMode.DENORM_FLUSH_TO_ZERO;
			case 4461:
				return ExecutionMode.SIGNED_ZERO_INF_NAN_PRESERVE;
			case 4462:
				return ExecutionMode.ROUNDING_MODE_RTE;
			case 4463:
				return ExecutionMode.ROUNDING_MODE_RTZ;
			case 4489:
				return ExecutionMode.NON_COHERENT_TILE_ATTACHMENT_READ_QCOM;
			case 4490:
				return ExecutionMode.TILE_SHADING_RATE_QCOM;
			case 5017:
				return ExecutionMode.EARLY_AND_LATE_FRAGMENT_TESTS_AMD;
			case 5027:
				return ExecutionMode.STENCIL_REF_REPLACING_EXT;
			case 5069:
				return ExecutionMode.COALESCING_AMDX;
			case 5070:
				return ExecutionMode.IS_API_ENTRY_AMDX;
			case 5071:
				return ExecutionMode.MAX_NODE_RECURSION_AMDX;
			case 5072:
				return ExecutionMode.STATIC_NUM_WORKGROUPS_AMDX;
			case 5073:
				return ExecutionMode.SHADER_INDEX_AMDX;
			case 5077:
				return ExecutionMode.MAX_NUM_WORKGROUPS_AMDX;
			case 5079:
				return ExecutionMode.STENCIL_REF_UNCHANGED_FRONT_AMD;
			case 5080:
				return ExecutionMode.STENCIL_REF_GREATER_FRONT_AMD;
			case 5081:
				return ExecutionMode.STENCIL_REF_LESS_FRONT_AMD;
			case 5082:
				return ExecutionMode.STENCIL_REF_UNCHANGED_BACK_AMD;
			case 5083:
				return ExecutionMode.STENCIL_REF_GREATER_BACK_AMD;
			case 5084:
				return ExecutionMode.STENCIL_REF_LESS_BACK_AMD;
			case 5088:
				return ExecutionMode.QUAD_DERIVATIVES_KHR;
			case 5089:
				return ExecutionMode.REQUIRE_FULL_QUADS_KHR;
			case 5102:
				return ExecutionMode.SHARES_INPUT_WITH_AMDX;
			case 5269:
				return ExecutionMode.OUTPUT_LINES_EXT;
			case 5270:
				return ExecutionMode.OUTPUT_PRIMITIVES_EXT;
			case 5289:
				return ExecutionMode.DERIVATIVE_GROUP_QUADS_KHR;
			case 5290:
				return ExecutionMode.DERIVATIVE_GROUP_LINEAR_KHR;
			case 5298:
				return ExecutionMode.OUTPUT_TRIANGLES_EXT;
			case 5366:
				return ExecutionMode.PIXEL_INTERLOCK_ORDERED_EXT;
			case 5367:
				return ExecutionMode.PIXEL_INTERLOCK_UNORDERED_EXT;
			case 5368:
				return ExecutionMode.SAMPLE_INTERLOCK_ORDERED_EXT;
			case 5369:
				return ExecutionMode.SAMPLE_INTERLOCK_UNORDERED_EXT;
			case 5370:
				return ExecutionMode.SHADING_RATE_INTERLOCK_ORDERED_EXT;
			case 5371:
				return ExecutionMode.SHADING_RATE_INTERLOCK_UNORDERED_EXT;
			case 5618:
				return ExecutionMode.SHARED_LOCAL_MEMORY_SIZE_INTEL;
			case 5620:
				return ExecutionMode.ROUNDING_MODE_RTPINTEL;
			case 5621:
				return ExecutionMode.ROUNDING_MODE_RTNINTEL;
			case 5622:
				return ExecutionMode.FLOATING_POINT_MODE_ALTINTEL;
			case 5623:
				return ExecutionMode.FLOATING_POINT_MODE_IEEEINTEL;
			case 5893:
				return ExecutionMode.MAX_WORKGROUP_SIZE_INTEL;
			case 5894:
				return ExecutionMode.MAX_WORK_DIM_INTEL;
			case 5895:
				return ExecutionMode.NO_GLOBAL_OFFSET_INTEL;
			case 5896:
				return ExecutionMode.NUM_SIMD_WORKITEMS_INTEL;
			case 5903:
				return ExecutionMode.SCHEDULER_TARGET_FMAX_MHZ_INTEL;
			case 6023:
				return ExecutionMode.MAXIMALLY_RECONVERGES_KHR;
			case 6028:
				return ExecutionMode.FP_FAST_MATH_DEFAULT;
			case 6154:
				return ExecutionMode.STREAMING_INTERFACE_INTEL;
			case 6160:
				return ExecutionMode.REGISTER_MAP_INTERFACE_INTEL;
			case 6417:
				return ExecutionMode.NAMED_BARRIER_COUNT_INTEL;
			case 6461:
				return ExecutionMode.MAXIMUM_REGISTERS_INTEL;
			case 6462:
				return ExecutionMode.MAXIMUM_REGISTERS_ID_INTEL;
			case 6463:
				return ExecutionMode.NAMED_MAXIMUM_REGISTERS_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}

	public Object[] loadArg(int[] data, int offset, Instruction[] instructions) {
		switch (this) {
			case NAMED_MAXIMUM_REGISTERS_INTEL:
				return new Object[] { NamedMaximumNumberOfRegisters.get(data[offset]) };
			case TILE_SHADING_RATE_QCOM:
			case MAX_WORKGROUP_SIZE_INTEL:
			case LOCAL_SIZE_HINT:
			case LOCAL_SIZE: {
				Object[] args = new Object[3];
				args[0] = data[offset];
				args[1] = data[offset + 1];
				args[2] = data[offset + 2];
				return args;
			}
			case FP_FAST_MATH_DEFAULT:
			case SHARES_INPUT_WITH_AMDX: {
				Object[] args = new Object[2];
				args[0] = instructions[data[offset]];
				args[1] = instructions[data[offset + 1]];
				return args;
			}
			case SUBGROUPS_PER_WORKGROUP_ID:
			case MAX_NODE_RECURSION_AMDX:
			case IS_API_ENTRY_AMDX:
			case SHADER_INDEX_AMDX:
			case MAXIMUM_REGISTERS_ID_INTEL:
				return new Object[] { instructions[data[offset]] };
			case REGISTER_MAP_INTERFACE_INTEL:
			case INVOCATIONS:
			case ROUNDING_MODE_RTE:
			case SUBGROUP_SIZE:
			case NAMED_BARRIER_COUNT_INTEL:
			case SUBGROUPS_PER_WORKGROUP:
			case MAXIMUM_REGISTERS_INTEL:
			case ROUNDING_MODE_RTPINTEL:
			case SIGNED_ZERO_INF_NAN_PRESERVE:
			case SHARED_LOCAL_MEMORY_SIZE_INTEL:
			case FLOATING_POINT_MODE_ALTINTEL:
			case OUTPUT_PRIMITIVES_EXT:
			case OUTPUT_VERTICES:
			case NUM_SIMD_WORKITEMS_INTEL:
			case MAX_WORK_DIM_INTEL:
			case STREAMING_INTERFACE_INTEL:
			case ROUNDING_MODE_RTNINTEL:
			case DENORM_FLUSH_TO_ZERO:
			case ROUNDING_MODE_RTZ:
			case FLOATING_POINT_MODE_IEEEINTEL:
			case DENORM_PRESERVE:
			case VEC_TYPE_HINT:
			case SCHEDULER_TARGET_FMAX_MHZ_INTEL:
				return new Object[] { data[offset] };
			case MAX_NUM_WORKGROUPS_AMDX:
			case LOCAL_SIZE_HINT_ID:
			case STATIC_NUM_WORKGROUPS_AMDX:
			case LOCAL_SIZE_ID: {
				Object[] args = new Object[3];
				args[0] = instructions[data[offset]];
				args[1] = instructions[data[offset + 1]];
				args[2] = instructions[data[offset + 2]];
				return args;
			}
			default:
				return new Object[0];
		}
	}
}