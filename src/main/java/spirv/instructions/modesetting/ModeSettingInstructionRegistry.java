package spirv.instructions.modesetting;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModeSettingInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> MODESETTING_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(14, OpMemoryModel::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(15, OpEntryPoint::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(16, OpExecutionMode::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(17, OpCapability::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(331, OpExecutionModeId::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(6249, OpConditionalEntryPointINTEL::new);
		ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY.put(6250, OpConditionalCapabilityINTEL::new);
	}
}