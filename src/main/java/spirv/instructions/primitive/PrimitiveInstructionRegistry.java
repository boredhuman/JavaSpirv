package spirv.instructions.primitive;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PrimitiveInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> PRIMITIVE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		PrimitiveInstructionRegistry.PRIMITIVE_INSTRUCTIONS_REGISTRY.put(218, OpEmitVertex::new);
		PrimitiveInstructionRegistry.PRIMITIVE_INSTRUCTIONS_REGISTRY.put(219, OpEndPrimitive::new);
		PrimitiveInstructionRegistry.PRIMITIVE_INSTRUCTIONS_REGISTRY.put(220, OpEmitStreamVertex::new);
		PrimitiveInstructionRegistry.PRIMITIVE_INSTRUCTIONS_REGISTRY.put(221, OpEndStreamPrimitive::new);
	}
}