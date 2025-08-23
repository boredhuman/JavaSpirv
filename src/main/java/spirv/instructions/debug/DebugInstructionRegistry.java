package spirv.instructions.debug;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DebugInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> DEBUG_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(2, OpSourceContinued::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(3, OpSource::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(4, OpSourceExtension::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(5, OpName::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(6, OpMemberName::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(7, OpString::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(8, OpLine::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(317, OpNoLine::new);
		DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY.put(330, OpModuleProcessed::new);
	}
}