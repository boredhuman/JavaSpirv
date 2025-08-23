package spirv.instructions.derivative;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DerivativeInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> DERIVATIVE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(207, OpDPdx::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(208, OpDPdy::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(209, OpFwidth::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(210, OpDPdxFine::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(211, OpDPdyFine::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(212, OpFwidthFine::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(213, OpDPdxCoarse::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(214, OpDPdyCoarse::new);
		DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY.put(215, OpFwidthCoarse::new);
	}
}