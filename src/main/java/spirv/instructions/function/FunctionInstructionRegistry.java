package spirv.instructions.function;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FunctionInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> FUNCTION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY.put(54, OpFunction::new);
		FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY.put(55, OpFunctionParameter::new);
		FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY.put(56, OpFunctionEnd::new);
		FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY.put(57, OpFunctionCall::new);
		FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY.put(5369, OpCooperativeMatrixPerElementOpNV::new);
	}
}