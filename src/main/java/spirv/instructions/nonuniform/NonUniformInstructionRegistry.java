package spirv.instructions.nonuniform;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NonUniformInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> NONUNIFORM_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(333, OpGroupNonUniformElect::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(334, OpGroupNonUniformAll::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(335, OpGroupNonUniformAny::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(336, OpGroupNonUniformAllEqual::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(337, OpGroupNonUniformBroadcast::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(338, OpGroupNonUniformBroadcastFirst::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(339, OpGroupNonUniformBallot::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(340, OpGroupNonUniformInverseBallot::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(341, OpGroupNonUniformBallotBitExtract::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(342, OpGroupNonUniformBallotBitCount::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(343, OpGroupNonUniformBallotFindLSB::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(344, OpGroupNonUniformBallotFindMSB::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(345, OpGroupNonUniformShuffle::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(346, OpGroupNonUniformShuffleXor::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(347, OpGroupNonUniformShuffleUp::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(348, OpGroupNonUniformShuffleDown::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(349, OpGroupNonUniformIAdd::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(350, OpGroupNonUniformFAdd::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(351, OpGroupNonUniformIMul::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(352, OpGroupNonUniformFMul::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(353, OpGroupNonUniformSMin::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(354, OpGroupNonUniformUMin::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(355, OpGroupNonUniformFMin::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(356, OpGroupNonUniformSMax::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(357, OpGroupNonUniformUMax::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(358, OpGroupNonUniformFMax::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(359, OpGroupNonUniformBitwiseAnd::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(360, OpGroupNonUniformBitwiseOr::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(361, OpGroupNonUniformBitwiseXor::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(362, OpGroupNonUniformLogicalAnd::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(363, OpGroupNonUniformLogicalOr::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(364, OpGroupNonUniformLogicalXor::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(365, OpGroupNonUniformQuadBroadcast::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(366, OpGroupNonUniformQuadSwap::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(5110, OpGroupNonUniformQuadAllKHR::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(5111, OpGroupNonUniformQuadAnyKHR::new);
		NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY.put(5296, OpGroupNonUniformPartitionNV::new);
	}
}