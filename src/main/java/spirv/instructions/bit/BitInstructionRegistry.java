package spirv.instructions.bit;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BitInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> BIT_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(194, OpShiftRightLogical::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(195, OpShiftRightArithmetic::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(196, OpShiftLeftLogical::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(197, OpBitwiseOr::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(198, OpBitwiseXor::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(199, OpBitwiseAnd::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(200, OpNot::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(201, OpBitFieldInsert::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(202, OpBitFieldSExtract::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(203, OpBitFieldUExtract::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(204, OpBitReverse::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(205, OpBitCount::new);
		BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY.put(6242, OpBitwiseFunctionINTEL::new);
	}
}