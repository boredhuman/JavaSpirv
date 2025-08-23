package spirv.instructions.devicesideenqueue;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DeviceSideEnqueueInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(291, OpEnqueueMarker::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(292, OpEnqueueKernel::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(293, OpGetKernelNDrangeSubGroupCount::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(294, OpGetKernelNDrangeMaxSubGroupSize::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(295, OpGetKernelWorkGroupSize::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(296, OpGetKernelPreferredWorkGroupSizeMultiple::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(297, OpRetainEvent::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(298, OpReleaseEvent::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(299, OpCreateUserEvent::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(300, OpIsValidEvent::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(301, OpSetUserEventStatus::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(302, OpCaptureEventProfilingInfo::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(303, OpGetDefaultQueue::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(304, OpBuildNDRange::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(325, OpGetKernelLocalSizeForSubgroupCount::new);
		DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY.put(326, OpGetKernelMaxNumSubgroups::new);
	}
}