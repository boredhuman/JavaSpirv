package spirv.instructions.atomic;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AtomicInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> ATOMIC_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(227, OpAtomicLoad::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(228, OpAtomicStore::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(229, OpAtomicExchange::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(230, OpAtomicCompareExchange::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(231, OpAtomicCompareExchangeWeak::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(232, OpAtomicIIncrement::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(233, OpAtomicIDecrement::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(234, OpAtomicIAdd::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(235, OpAtomicISub::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(236, OpAtomicSMin::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(237, OpAtomicUMin::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(238, OpAtomicSMax::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(239, OpAtomicUMax::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(240, OpAtomicAnd::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(241, OpAtomicOr::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(242, OpAtomicXor::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(318, OpAtomicFlagTestAndSet::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(319, OpAtomicFlagClear::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(5614, OpAtomicFMinEXT::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(5615, OpAtomicFMaxEXT::new);
		AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY.put(6035, OpAtomicFAddEXT::new);
	}
}