package spirv.instructions.graph;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GraphInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> GRAPH_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4181, OpGraphConstantARM::new);
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4182, OpGraphEntryPointARM::new);
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4183, OpGraphARM::new);
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4184, OpGraphInputARM::new);
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4185, OpGraphSetOutputARM::new);
		GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY.put(4186, OpGraphEndARM::new);
	}
}