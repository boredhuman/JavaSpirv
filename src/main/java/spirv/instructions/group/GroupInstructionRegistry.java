package spirv.instructions.group;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GroupInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> GROUP_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(259, OpGroupAsyncCopy::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(260, OpGroupWaitEvents::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(261, OpGroupAll::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(262, OpGroupAny::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(263, OpGroupBroadcast::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(264, OpGroupIAdd::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(265, OpGroupFAdd::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(266, OpGroupFMin::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(267, OpGroupUMin::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(268, OpGroupSMin::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(269, OpGroupFMax::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(270, OpGroupUMax::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(271, OpGroupSMax::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4421, OpSubgroupBallotKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4422, OpSubgroupFirstInvocationKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4428, OpSubgroupAllKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4429, OpSubgroupAnyKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4430, OpSubgroupAllEqualKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4431, OpGroupNonUniformRotateKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4432, OpSubgroupReadInvocationKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(4434, OpUntypedGroupAsyncCopyKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5000, OpGroupIAddNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5001, OpGroupFAddNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5002, OpGroupFMinNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5003, OpGroupUMinNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5004, OpGroupSMinNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5005, OpGroupFMaxNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5006, OpGroupUMaxNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5007, OpGroupSMaxNonUniformAMD::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5571, OpSubgroupShuffleINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5572, OpSubgroupShuffleDownINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5573, OpSubgroupShuffleUpINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5574, OpSubgroupShuffleXorINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5575, OpSubgroupBlockReadINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5576, OpSubgroupBlockWriteINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5577, OpSubgroupImageBlockReadINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5578, OpSubgroupImageBlockWriteINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5580, OpSubgroupImageMediaBlockReadINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(5581, OpSubgroupImageMediaBlockWriteINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6221, OpSubgroupBlockPrefetchINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6231, OpSubgroup2DBlockLoadINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6232, OpSubgroup2DBlockLoadTransformINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6233, OpSubgroup2DBlockLoadTransposeINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6234, OpSubgroup2DBlockPrefetchINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6235, OpSubgroup2DBlockStoreINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6237, OpSubgroupMatrixMultiplyAccumulateINTEL::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6401, OpGroupIMulKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6402, OpGroupFMulKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6403, OpGroupBitwiseAndKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6404, OpGroupBitwiseOrKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6405, OpGroupBitwiseXorKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6406, OpGroupLogicalAndKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6407, OpGroupLogicalOrKHR::new);
		GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY.put(6408, OpGroupLogicalXorKHR::new);
	}
}