package spirv.instructions.memory;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MemoryInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> MEMORY_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(59, OpVariable::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(60, OpImageTexelPointer::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(61, OpLoad::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(62, OpStore::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(63, OpCopyMemory::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(64, OpCopyMemorySized::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(65, OpAccessChain::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(66, OpInBoundsAccessChain::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(67, OpPtrAccessChain::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(68, OpArrayLength::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(69, OpGenericPtrMemSemantics::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(70, OpInBoundsPtrAccessChain::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(401, OpPtrEqual::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(402, OpPtrNotEqual::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(403, OpPtrDiff::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4418, OpUntypedVariableKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4419, OpUntypedAccessChainKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4420, OpUntypedInBoundsAccessChainKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4423, OpUntypedPtrAccessChainKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4424, OpUntypedInBoundsPtrAccessChainKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4425, OpUntypedArrayLengthKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4426, OpUntypedPrefetchKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4457, OpCooperativeMatrixLoadKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(4458, OpCooperativeMatrixStoreKHR::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(5302, OpCooperativeVectorLoadNV::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(5303, OpCooperativeVectorStoreNV::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(5367, OpCooperativeMatrixLoadTensorNV::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(5368, OpCooperativeMatrixStoreTensorNV::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(5398, OpRawAccessChainNV::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(6428, OpMaskedGatherINTEL::new);
		MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY.put(6429, OpMaskedScatterINTEL::new);
	}
}