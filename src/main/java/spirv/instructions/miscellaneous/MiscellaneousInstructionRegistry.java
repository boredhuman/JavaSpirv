package spirv.instructions.miscellaneous;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MiscellaneousInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> MISCELLANEOUS_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(0, OpNop::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(1, OpUndef::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(321, OpSizeOf::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(4460, OpCooperativeMatrixLengthKHR::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(5630, OpAssumeTrueKHR::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(5631, OpExpectKHR::new);
		MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY.put(6145, OpArithmeticFenceEXT::new);
	}
}