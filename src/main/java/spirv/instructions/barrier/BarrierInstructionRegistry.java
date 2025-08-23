package spirv.instructions.barrier;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BarrierInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> BARRIER_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(224, OpControlBarrier::new);
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(225, OpMemoryBarrier::new);
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(328, OpNamedBarrierInitialize::new);
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(329, OpMemoryNamedBarrier::new);
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(6142, OpControlBarrierArriveINTEL::new);
		BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY.put(6143, OpControlBarrierWaitINTEL::new);
	}
}