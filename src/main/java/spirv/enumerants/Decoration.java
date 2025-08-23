package spirv.enumerants;

import spirv.instructions.ValueEnum;
import spirv.instructions.Instruction;
import spirv.instructions.StringData;
import spirv.instructions.InstructionUtil;

public enum Decoration implements ValueEnum {
	RELAXED_PRECISION(0, 0),
	SPEC_ID(1, 1),
	BLOCK(2, 0),
	BUFFER_BLOCK(3, 0),
	ROW_MAJOR(4, 0),
	COL_MAJOR(5, 0),
	ARRAY_STRIDE(6, 1),
	MATRIX_STRIDE(7, 1),
	GLSL_SHARED(8, 0),
	GLSL_PACKED(9, 0),
	C_PACKED(10, 0),
	BUILT_IN(11, 1),
	NO_PERSPECTIVE(13, 0),
	FLAT(14, 0),
	PATCH(15, 0),
	CENTROID(16, 0),
	SAMPLE(17, 0),
	INVARIANT(18, 0),
	RESTRICT(19, 0),
	ALIASED(20, 0),
	VOLATILE(21, 0),
	CONSTANT(22, 0),
	COHERENT(23, 0),
	NON_WRITABLE(24, 0),
	NON_READABLE(25, 0),
	UNIFORM(26, 0),
	UNIFORM_ID(27, 1),
	SATURATED_CONVERSION(28, 0),
	STREAM(29, 1),
	LOCATION(30, 1),
	COMPONENT(31, 1),
	INDEX(32, 1),
	BINDING(33, 1),
	DESCRIPTOR_SET(34, 1),
	OFFSET(35, 1),
	XFB_BUFFER(36, 1),
	XFB_STRIDE(37, 1),
	FUNC_PARAM_ATTR(38, 1),
	FP_ROUNDING_MODE(39, 1),
	FP_FAST_MATH_MODE(40, 1),
	LINKAGE_ATTRIBUTES(41, 2),
	NO_CONTRACTION(42, 0),
	INPUT_ATTACHMENT_INDEX(43, 1),
	ALIGNMENT(44, 1),
	MAX_BYTE_OFFSET(45, 1),
	ALIGNMENT_ID(46, 1),
	MAX_BYTE_OFFSET_ID(47, 1),
	SATURATED_TO_LARGEST_FLOAT8_NORMAL_CONVERSION_EXT(4216, 0),
	NO_SIGNED_WRAP(4469, 0),
	NO_UNSIGNED_WRAP(4470, 0),
	WEIGHT_TEXTURE_QCOM(4487, 0),
	BLOCK_MATCH_TEXTURE_QCOM(4488, 0),
	BLOCK_MATCH_SAMPLER_QCOM(4499, 0),
	EXPLICIT_INTERP_AMD(4999, 0),
	NODE_SHARES_PAYLOAD_LIMITS_WITH_AMDX(5019, 1),
	NODE_MAX_PAYLOADS_AMDX(5020, 1),
	TRACK_FINISH_WRITING_AMDX(5078, 0),
	PAYLOAD_NODE_NAME_AMDX(5091, 1),
	PAYLOAD_NODE_BASE_INDEX_AMDX(5098, 1),
	PAYLOAD_NODE_SPARSE_ARRAY_AMDX(5099, 0),
	PAYLOAD_NODE_ARRAY_SIZE_AMDX(5100, 1),
	PAYLOAD_DISPATCH_INDIRECT_AMDX(5105, 0),
	OVERRIDE_COVERAGE_NV(5248, 0),
	PASSTHROUGH_NV(5250, 0),
	VIEWPORT_RELATIVE_NV(5252, 0),
	SECONDARY_VIEWPORT_RELATIVE_NV(5256, 1),
	PER_PRIMITIVE_EXT(5271, 0),
	PER_VIEW_NV(5272, 0),
	PER_TASK_NV(5273, 0),
	PER_VERTEX_KHR(5285, 0),
	NON_UNIFORM(5300, 0),
	RESTRICT_POINTER(5355, 0),
	ALIASED_POINTER(5356, 0),
	HIT_OBJECT_SHADER_RECORD_BUFFER_NV(5386, 0),
	BINDLESS_SAMPLER_NV(5398, 0),
	BINDLESS_IMAGE_NV(5399, 0),
	BOUND_SAMPLER_NV(5400, 0),
	BOUND_IMAGE_NV(5401, 0),
	SIMT_CALL_INTEL(5599, 1),
	REFERENCED_INDIRECTLY_INTEL(5602, 0),
	CLOBBER_INTEL(5607, 1),
	SIDE_EFFECTS_INTEL(5608, 0),
	VECTOR_COMPUTE_VARIABLE_INTEL(5624, 0),
	FUNC_PARAM_IO_KIND_INTEL(5625, 1),
	VECTOR_COMPUTE_FUNCTION_INTEL(5626, 0),
	STACK_CALL_INTEL(5627, 0),
	GLOBAL_VARIABLE_OFFSET_INTEL(5628, 1),
	COUNTER_BUFFER(5634, 1),
	USER_SEMANTIC(5635, 1),
	USER_TYPE_GOOGLE(5636, 1),
	FUNCTION_ROUNDING_MODE_INTEL(5822, 2),
	FUNCTION_DENORM_MODE_INTEL(5823, 2),
	REGISTER_INTEL(5825, 0),
	MEMORY_INTEL(5826, 1),
	NUMBANKS_INTEL(5827, 1),
	BANKWIDTH_INTEL(5828, 1),
	MAX_PRIVATE_COPIES_INTEL(5829, 1),
	SINGLEPUMP_INTEL(5830, 0),
	DOUBLEPUMP_INTEL(5831, 0),
	MAX_REPLICATES_INTEL(5832, 1),
	SIMPLE_DUAL_PORT_INTEL(5833, 0),
	MERGE_INTEL(5834, 2),
	BANK_BITS_INTEL(5835, 1),
	FORCE_POW2_DEPTH_INTEL(5836, 1),
	STRIDESIZE_INTEL(5883, 1),
	WORDSIZE_INTEL(5884, 1),
	TRUE_DUAL_PORT_INTEL(5885, 0),
	BURST_COALESCE_INTEL(5899, 0),
	CACHE_SIZE_INTEL(5900, 1),
	DONT_STATICALLY_COALESCE_INTEL(5901, 0),
	PREFETCH_INTEL(5902, 1),
	STALL_ENABLE_INTEL(5905, 0),
	FUSE_LOOPS_IN_FUNCTION_INTEL(5907, 0),
	MATH_OP_DSP_MODE_INTEL(5909, 2),
	ALIAS_SCOPE_INTEL(5914, 1),
	NO_ALIAS_INTEL(5915, 1),
	INITIATION_INTERVAL_INTEL(5917, 1),
	MAX_CONCURRENCY_INTEL(5918, 1),
	PIPELINE_ENABLE_INTEL(5919, 1),
	BUFFER_LOCATION_INTEL(5921, 1),
	IO_PIPE_STORAGE_INTEL(5944, 1),
	FUNCTION_FLOATING_POINT_MODE_INTEL(6080, 2),
	SINGLE_ELEMENT_VECTOR_INTEL(6085, 0),
	VECTOR_COMPUTE_CALLABLE_FUNCTION_INTEL(6087, 0),
	MEDIA_BLOCK_IOINTEL(6140, 0),
	STALL_FREE_INTEL(6151, 0),
	FP_MAX_ERROR_DECORATION_INTEL(6170, 1),
	LATENCY_CONTROL_LABEL_INTEL(6172, 1),
	LATENCY_CONTROL_CONSTRAINT_INTEL(6173, 3),
	CONDUIT_KERNEL_ARGUMENT_INTEL(6175, 0),
	REGISTER_MAP_KERNEL_ARGUMENT_INTEL(6176, 0),
	MM_HOST_INTERFACE_ADDRESS_WIDTH_INTEL(6177, 1),
	MM_HOST_INTERFACE_DATA_WIDTH_INTEL(6178, 1),
	MM_HOST_INTERFACE_LATENCY_INTEL(6179, 1),
	MM_HOST_INTERFACE_READ_WRITE_MODE_INTEL(6180, 1),
	MM_HOST_INTERFACE_MAX_BURST_INTEL(6181, 1),
	MM_HOST_INTERFACE_WAIT_REQUEST_INTEL(6182, 1),
	STABLE_KERNEL_ARGUMENT_INTEL(6183, 0),
	HOST_ACCESS_INTEL(6188, 2),
	INIT_MODE_INTEL(6190, 1),
	IMPLEMENT_IN_REGISTER_MAP_INTEL(6191, 1),
	CONDITIONAL_INTEL(6247, 1),
	CACHE_CONTROL_LOAD_INTEL(6442, 2),
	CACHE_CONTROL_STORE_INTEL(6443, 2);

	public static final Decoration[] VALUES = Decoration.values();

	public final int value;
	public final int argumentCount;

	Decoration(int value, int argumentCount) {
		this.value = value;
		this.argumentCount = argumentCount;
	}

	public int value() {
		return this.value;
	}

	public static Decoration get(int value) {
		switch (value) {
			case 0:
				return Decoration.RELAXED_PRECISION;
			case 1:
				return Decoration.SPEC_ID;
			case 2:
				return Decoration.BLOCK;
			case 3:
				return Decoration.BUFFER_BLOCK;
			case 4:
				return Decoration.ROW_MAJOR;
			case 5:
				return Decoration.COL_MAJOR;
			case 6:
				return Decoration.ARRAY_STRIDE;
			case 7:
				return Decoration.MATRIX_STRIDE;
			case 8:
				return Decoration.GLSL_SHARED;
			case 9:
				return Decoration.GLSL_PACKED;
			case 10:
				return Decoration.C_PACKED;
			case 11:
				return Decoration.BUILT_IN;
			case 13:
				return Decoration.NO_PERSPECTIVE;
			case 14:
				return Decoration.FLAT;
			case 15:
				return Decoration.PATCH;
			case 16:
				return Decoration.CENTROID;
			case 17:
				return Decoration.SAMPLE;
			case 18:
				return Decoration.INVARIANT;
			case 19:
				return Decoration.RESTRICT;
			case 20:
				return Decoration.ALIASED;
			case 21:
				return Decoration.VOLATILE;
			case 22:
				return Decoration.CONSTANT;
			case 23:
				return Decoration.COHERENT;
			case 24:
				return Decoration.NON_WRITABLE;
			case 25:
				return Decoration.NON_READABLE;
			case 26:
				return Decoration.UNIFORM;
			case 27:
				return Decoration.UNIFORM_ID;
			case 28:
				return Decoration.SATURATED_CONVERSION;
			case 29:
				return Decoration.STREAM;
			case 30:
				return Decoration.LOCATION;
			case 31:
				return Decoration.COMPONENT;
			case 32:
				return Decoration.INDEX;
			case 33:
				return Decoration.BINDING;
			case 34:
				return Decoration.DESCRIPTOR_SET;
			case 35:
				return Decoration.OFFSET;
			case 36:
				return Decoration.XFB_BUFFER;
			case 37:
				return Decoration.XFB_STRIDE;
			case 38:
				return Decoration.FUNC_PARAM_ATTR;
			case 39:
				return Decoration.FP_ROUNDING_MODE;
			case 40:
				return Decoration.FP_FAST_MATH_MODE;
			case 41:
				return Decoration.LINKAGE_ATTRIBUTES;
			case 42:
				return Decoration.NO_CONTRACTION;
			case 43:
				return Decoration.INPUT_ATTACHMENT_INDEX;
			case 44:
				return Decoration.ALIGNMENT;
			case 45:
				return Decoration.MAX_BYTE_OFFSET;
			case 46:
				return Decoration.ALIGNMENT_ID;
			case 47:
				return Decoration.MAX_BYTE_OFFSET_ID;
			case 4216:
				return Decoration.SATURATED_TO_LARGEST_FLOAT8_NORMAL_CONVERSION_EXT;
			case 4469:
				return Decoration.NO_SIGNED_WRAP;
			case 4470:
				return Decoration.NO_UNSIGNED_WRAP;
			case 4487:
				return Decoration.WEIGHT_TEXTURE_QCOM;
			case 4488:
				return Decoration.BLOCK_MATCH_TEXTURE_QCOM;
			case 4499:
				return Decoration.BLOCK_MATCH_SAMPLER_QCOM;
			case 4999:
				return Decoration.EXPLICIT_INTERP_AMD;
			case 5019:
				return Decoration.NODE_SHARES_PAYLOAD_LIMITS_WITH_AMDX;
			case 5020:
				return Decoration.NODE_MAX_PAYLOADS_AMDX;
			case 5078:
				return Decoration.TRACK_FINISH_WRITING_AMDX;
			case 5091:
				return Decoration.PAYLOAD_NODE_NAME_AMDX;
			case 5098:
				return Decoration.PAYLOAD_NODE_BASE_INDEX_AMDX;
			case 5099:
				return Decoration.PAYLOAD_NODE_SPARSE_ARRAY_AMDX;
			case 5100:
				return Decoration.PAYLOAD_NODE_ARRAY_SIZE_AMDX;
			case 5105:
				return Decoration.PAYLOAD_DISPATCH_INDIRECT_AMDX;
			case 5248:
				return Decoration.OVERRIDE_COVERAGE_NV;
			case 5250:
				return Decoration.PASSTHROUGH_NV;
			case 5252:
				return Decoration.VIEWPORT_RELATIVE_NV;
			case 5256:
				return Decoration.SECONDARY_VIEWPORT_RELATIVE_NV;
			case 5271:
				return Decoration.PER_PRIMITIVE_EXT;
			case 5272:
				return Decoration.PER_VIEW_NV;
			case 5273:
				return Decoration.PER_TASK_NV;
			case 5285:
				return Decoration.PER_VERTEX_KHR;
			case 5300:
				return Decoration.NON_UNIFORM;
			case 5355:
				return Decoration.RESTRICT_POINTER;
			case 5356:
				return Decoration.ALIASED_POINTER;
			case 5386:
				return Decoration.HIT_OBJECT_SHADER_RECORD_BUFFER_NV;
			case 5398:
				return Decoration.BINDLESS_SAMPLER_NV;
			case 5399:
				return Decoration.BINDLESS_IMAGE_NV;
			case 5400:
				return Decoration.BOUND_SAMPLER_NV;
			case 5401:
				return Decoration.BOUND_IMAGE_NV;
			case 5599:
				return Decoration.SIMT_CALL_INTEL;
			case 5602:
				return Decoration.REFERENCED_INDIRECTLY_INTEL;
			case 5607:
				return Decoration.CLOBBER_INTEL;
			case 5608:
				return Decoration.SIDE_EFFECTS_INTEL;
			case 5624:
				return Decoration.VECTOR_COMPUTE_VARIABLE_INTEL;
			case 5625:
				return Decoration.FUNC_PARAM_IO_KIND_INTEL;
			case 5626:
				return Decoration.VECTOR_COMPUTE_FUNCTION_INTEL;
			case 5627:
				return Decoration.STACK_CALL_INTEL;
			case 5628:
				return Decoration.GLOBAL_VARIABLE_OFFSET_INTEL;
			case 5634:
				return Decoration.COUNTER_BUFFER;
			case 5635:
				return Decoration.USER_SEMANTIC;
			case 5636:
				return Decoration.USER_TYPE_GOOGLE;
			case 5822:
				return Decoration.FUNCTION_ROUNDING_MODE_INTEL;
			case 5823:
				return Decoration.FUNCTION_DENORM_MODE_INTEL;
			case 5825:
				return Decoration.REGISTER_INTEL;
			case 5826:
				return Decoration.MEMORY_INTEL;
			case 5827:
				return Decoration.NUMBANKS_INTEL;
			case 5828:
				return Decoration.BANKWIDTH_INTEL;
			case 5829:
				return Decoration.MAX_PRIVATE_COPIES_INTEL;
			case 5830:
				return Decoration.SINGLEPUMP_INTEL;
			case 5831:
				return Decoration.DOUBLEPUMP_INTEL;
			case 5832:
				return Decoration.MAX_REPLICATES_INTEL;
			case 5833:
				return Decoration.SIMPLE_DUAL_PORT_INTEL;
			case 5834:
				return Decoration.MERGE_INTEL;
			case 5835:
				return Decoration.BANK_BITS_INTEL;
			case 5836:
				return Decoration.FORCE_POW2_DEPTH_INTEL;
			case 5883:
				return Decoration.STRIDESIZE_INTEL;
			case 5884:
				return Decoration.WORDSIZE_INTEL;
			case 5885:
				return Decoration.TRUE_DUAL_PORT_INTEL;
			case 5899:
				return Decoration.BURST_COALESCE_INTEL;
			case 5900:
				return Decoration.CACHE_SIZE_INTEL;
			case 5901:
				return Decoration.DONT_STATICALLY_COALESCE_INTEL;
			case 5902:
				return Decoration.PREFETCH_INTEL;
			case 5905:
				return Decoration.STALL_ENABLE_INTEL;
			case 5907:
				return Decoration.FUSE_LOOPS_IN_FUNCTION_INTEL;
			case 5909:
				return Decoration.MATH_OP_DSP_MODE_INTEL;
			case 5914:
				return Decoration.ALIAS_SCOPE_INTEL;
			case 5915:
				return Decoration.NO_ALIAS_INTEL;
			case 5917:
				return Decoration.INITIATION_INTERVAL_INTEL;
			case 5918:
				return Decoration.MAX_CONCURRENCY_INTEL;
			case 5919:
				return Decoration.PIPELINE_ENABLE_INTEL;
			case 5921:
				return Decoration.BUFFER_LOCATION_INTEL;
			case 5944:
				return Decoration.IO_PIPE_STORAGE_INTEL;
			case 6080:
				return Decoration.FUNCTION_FLOATING_POINT_MODE_INTEL;
			case 6085:
				return Decoration.SINGLE_ELEMENT_VECTOR_INTEL;
			case 6087:
				return Decoration.VECTOR_COMPUTE_CALLABLE_FUNCTION_INTEL;
			case 6140:
				return Decoration.MEDIA_BLOCK_IOINTEL;
			case 6151:
				return Decoration.STALL_FREE_INTEL;
			case 6170:
				return Decoration.FP_MAX_ERROR_DECORATION_INTEL;
			case 6172:
				return Decoration.LATENCY_CONTROL_LABEL_INTEL;
			case 6173:
				return Decoration.LATENCY_CONTROL_CONSTRAINT_INTEL;
			case 6175:
				return Decoration.CONDUIT_KERNEL_ARGUMENT_INTEL;
			case 6176:
				return Decoration.REGISTER_MAP_KERNEL_ARGUMENT_INTEL;
			case 6177:
				return Decoration.MM_HOST_INTERFACE_ADDRESS_WIDTH_INTEL;
			case 6178:
				return Decoration.MM_HOST_INTERFACE_DATA_WIDTH_INTEL;
			case 6179:
				return Decoration.MM_HOST_INTERFACE_LATENCY_INTEL;
			case 6180:
				return Decoration.MM_HOST_INTERFACE_READ_WRITE_MODE_INTEL;
			case 6181:
				return Decoration.MM_HOST_INTERFACE_MAX_BURST_INTEL;
			case 6182:
				return Decoration.MM_HOST_INTERFACE_WAIT_REQUEST_INTEL;
			case 6183:
				return Decoration.STABLE_KERNEL_ARGUMENT_INTEL;
			case 6188:
				return Decoration.HOST_ACCESS_INTEL;
			case 6190:
				return Decoration.INIT_MODE_INTEL;
			case 6191:
				return Decoration.IMPLEMENT_IN_REGISTER_MAP_INTEL;
			case 6247:
				return Decoration.CONDITIONAL_INTEL;
			case 6442:
				return Decoration.CACHE_CONTROL_LOAD_INTEL;
			case 6443:
				return Decoration.CACHE_CONTROL_STORE_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}

	public Object[] loadArg(int[] data, int offset, Instruction[] instructions) {
		switch (this) {
			case FUNCTION_FLOATING_POINT_MODE_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = FPOperationMode.get(data[offset + 1]);
				return args;
			}
			case LATENCY_CONTROL_CONSTRAINT_INTEL: {
				Object[] args = new Object[3];
				args[0] = data[offset];
				args[1] = data[offset + 1];
				args[2] = data[offset + 2];
				return args;
			}
			case MERGE_INTEL: {
				Object[] args = new Object[2];
				StringData stringData = InstructionUtil.readString(data, offset);
				offset += stringData.getWordCount();
				args[0] = stringData.getString();
				stringData = InstructionUtil.readString(data, offset + 1);
				args[1] = stringData.getString();
				return args;
			}
			case CACHE_CONTROL_LOAD_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = LoadCacheControl.get(data[offset + 1]);
				return args;
			}
			case FUNCTION_DENORM_MODE_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = FPDenormMode.get(data[offset + 1]);
				return args;
			}
			case FP_ROUNDING_MODE:
				return new Object[] { FPRoundingMode.get(data[offset]) };
			case MM_HOST_INTERFACE_READ_WRITE_MODE_INTEL:
				return new Object[] { AccessQualifier.get(data[offset]) };
			case FUNCTION_ROUNDING_MODE_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = FPRoundingMode.get(data[offset + 1]);
				return args;
			}
			case ALIAS_SCOPE_INTEL:
			case UNIFORM_ID:
			case PAYLOAD_NODE_BASE_INDEX_AMDX:
			case CONDITIONAL_INTEL:
			case NODE_SHARES_PAYLOAD_LIMITS_WITH_AMDX:
			case PAYLOAD_NODE_ARRAY_SIZE_AMDX:
			case COUNTER_BUFFER:
			case PAYLOAD_NODE_NAME_AMDX:
			case ALIGNMENT_ID:
			case NODE_MAX_PAYLOADS_AMDX:
			case NO_ALIAS_INTEL:
			case MAX_BYTE_OFFSET_ID:
				return new Object[] { instructions[data[offset]] };
			case FP_MAX_ERROR_DECORATION_INTEL:
				return new Object[] { Float.intBitsToFloat(data[offset]) };
			case INIT_MODE_INTEL:
				return new Object[] { InitializationModeQualifier.get(data[offset]) };
			case LINKAGE_ATTRIBUTES: {
				Object[] args = new Object[2];
				StringData stringData = InstructionUtil.readString(data, offset);
				offset += stringData.getWordCount();
				args[0] = stringData.getString();
				args[1] = LinkageType.get(data[offset + 1]);
				return args;
			}
			case MATH_OP_DSP_MODE_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = data[offset + 1];
				return args;
			}
			case CACHE_CONTROL_STORE_INTEL: {
				Object[] args = new Object[2];
				args[0] = data[offset];
				args[1] = StoreCacheControl.get(data[offset + 1]);
				return args;
			}
			case FUNC_PARAM_ATTR:
				return new Object[] { FunctionParameterAttribute.get(data[offset]) };
			case STRIDESIZE_INTEL:
			case WORDSIZE_INTEL:
			case INDEX:
			case DESCRIPTOR_SET:
			case MM_HOST_INTERFACE_LATENCY_INTEL:
			case ALIGNMENT:
			case XFB_STRIDE:
			case MM_HOST_INTERFACE_WAIT_REQUEST_INTEL:
			case STREAM:
			case MM_HOST_INTERFACE_DATA_WIDTH_INTEL:
			case CACHE_SIZE_INTEL:
			case BINDING:
			case PIPELINE_ENABLE_INTEL:
			case FP_FAST_MATH_MODE:
			case SPEC_ID:
			case OFFSET:
			case NUMBANKS_INTEL:
			case MAX_BYTE_OFFSET:
			case SECONDARY_VIEWPORT_RELATIVE_NV:
			case FORCE_POW2_DEPTH_INTEL:
			case GLOBAL_VARIABLE_OFFSET_INTEL:
			case MAX_PRIVATE_COPIES_INTEL:
			case MAX_REPLICATES_INTEL:
			case FUNC_PARAM_IO_KIND_INTEL:
			case BANK_BITS_INTEL:
			case IMPLEMENT_IN_REGISTER_MAP_INTEL:
			case MATRIX_STRIDE:
			case PREFETCH_INTEL:
			case INPUT_ATTACHMENT_INDEX:
			case INITIATION_INTERVAL_INTEL:
			case SIMT_CALL_INTEL:
			case BANKWIDTH_INTEL:
			case XFB_BUFFER:
			case COMPONENT:
			case BUFFER_LOCATION_INTEL:
			case LATENCY_CONTROL_LABEL_INTEL:
			case ARRAY_STRIDE:
			case MM_HOST_INTERFACE_ADDRESS_WIDTH_INTEL:
			case MM_HOST_INTERFACE_MAX_BURST_INTEL:
			case IO_PIPE_STORAGE_INTEL:
			case LOCATION:
			case MAX_CONCURRENCY_INTEL:
				return new Object[] { data[offset] };
			case MEMORY_INTEL:
			case CLOBBER_INTEL:
			case USER_SEMANTIC:
			case USER_TYPE_GOOGLE:
				return new Object[] { InstructionUtil.readString(data, offset).getString() };
			case HOST_ACCESS_INTEL: {
				Object[] args = new Object[2];
				args[0] = HostAccessQualifier.get(data[offset]);
				StringData stringData = InstructionUtil.readString(data, offset + 1);
				args[1] = stringData.getString();
				return args;
			}
			case BUILT_IN:
				return new Object[] { BuiltIn.get(data[offset]) };
			default:
				return new Object[0];
		}
	}

	public int size(Object[] args) {
		switch (this) {
			case LINKAGE_ATTRIBUTES:
				return InstructionUtil.wordCount((String) args[0]) + 1;
			case HOST_ACCESS_INTEL:
				return InstructionUtil.wordCount((String) args[1]) + 1;
			case MERGE_INTEL:
				return InstructionUtil.wordCount((String) args[0]) + InstructionUtil.wordCount((String) args[1]);
			case USER_TYPE_GOOGLE:
			case MEMORY_INTEL:
			case USER_SEMANTIC:
			case CLOBBER_INTEL:
				return InstructionUtil.wordCount((String) args[0]);
			default:
				return this.argumentCount;
		}
	}
}