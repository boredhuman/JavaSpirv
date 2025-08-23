package spirv.instructions.relationalandlogical;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RelationalandLogicalInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(154, OpAny::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(155, OpAll::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(156, OpIsNan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(157, OpIsInf::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(158, OpIsFinite::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(159, OpIsNormal::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(160, OpSignBitSet::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(161, OpLessOrGreater::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(162, OpOrdered::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(163, OpUnordered::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(164, OpLogicalEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(165, OpLogicalNotEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(166, OpLogicalOr::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(167, OpLogicalAnd::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(168, OpLogicalNot::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(169, OpSelect::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(170, OpIEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(171, OpINotEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(172, OpUGreaterThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(173, OpSGreaterThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(174, OpUGreaterThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(175, OpSGreaterThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(176, OpULessThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(177, OpSLessThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(178, OpULessThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(179, OpSLessThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(180, OpFOrdEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(181, OpFUnordEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(182, OpFOrdNotEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(183, OpFUnordNotEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(184, OpFOrdLessThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(185, OpFUnordLessThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(186, OpFOrdGreaterThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(187, OpFUnordGreaterThan::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(188, OpFOrdLessThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(189, OpFUnordLessThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(190, OpFOrdGreaterThanEqual::new);
		RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY.put(191, OpFUnordGreaterThanEqual::new);
	}
}