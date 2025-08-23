package spirv.instructions.controlflow;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ControlFlowInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> CONTROLFLOW_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(245, OpPhi::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(246, OpLoopMerge::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(247, OpSelectionMerge::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(248, OpLabel::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(249, OpBranch::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(250, OpBranchConditional::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(251, OpSwitch::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(252, OpKill::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(253, OpReturn::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(254, OpReturnValue::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(255, OpUnreachable::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(256, OpLifetimeStart::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(257, OpLifetimeStop::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(4416, OpTerminateInvocation::new);
		ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY.put(5380, OpDemoteToHelperInvocation::new);
	}
}