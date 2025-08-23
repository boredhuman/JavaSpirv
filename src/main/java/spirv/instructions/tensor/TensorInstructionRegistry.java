package spirv.instructions.tensor;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TensorInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> TENSOR_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		TensorInstructionRegistry.TENSOR_INSTRUCTIONS_REGISTRY.put(4164, OpTensorReadARM::new);
		TensorInstructionRegistry.TENSOR_INSTRUCTIONS_REGISTRY.put(4165, OpTensorWriteARM::new);
		TensorInstructionRegistry.TENSOR_INSTRUCTIONS_REGISTRY.put(4166, OpTensorQuerySizeARM::new);
	}
}