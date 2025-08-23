package spirv.instructions.pipe;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PipeInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> PIPE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(274, OpReadPipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(275, OpWritePipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(276, OpReservedReadPipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(277, OpReservedWritePipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(278, OpReserveReadPipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(279, OpReserveWritePipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(280, OpCommitReadPipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(281, OpCommitWritePipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(282, OpIsValidReserveId::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(283, OpGetNumPipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(284, OpGetMaxPipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(285, OpGroupReserveReadPipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(286, OpGroupReserveWritePipePackets::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(287, OpGroupCommitReadPipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(288, OpGroupCommitWritePipe::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(323, OpConstantPipeStorage::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(324, OpCreatePipeFromPipeStorage::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(5946, OpReadPipeBlockingINTEL::new);
		PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY.put(5947, OpWritePipeBlockingINTEL::new);
	}
}