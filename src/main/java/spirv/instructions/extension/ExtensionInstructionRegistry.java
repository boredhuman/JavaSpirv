package spirv.instructions.extension;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ExtensionInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> EXTENSION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY.put(10, OpExtension::new);
		ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY.put(11, OpExtInstImport::new);
		ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY.put(12, OpExtInst::new);
		ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY.put(4433, OpExtInstWithForwardRefsKHR::new);
		ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY.put(6248, OpConditionalExtensionINTEL::new);
	}
}