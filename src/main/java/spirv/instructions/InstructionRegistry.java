package spirv.instructions;

import spirv.instructions.group.GroupInstructionRegistry;
import spirv.instructions.miscellaneous.MiscellaneousInstructionRegistry;
import spirv.instructions.memory.MemoryInstructionRegistry;
import spirv.instructions.atomic.AtomicInstructionRegistry;
import spirv.instructions.barrier.BarrierInstructionRegistry;
import spirv.instructions.image.ImageInstructionRegistry;
import spirv.instructions.function.FunctionInstructionRegistry;
import spirv.instructions.primitive.PrimitiveInstructionRegistry;
import spirv.instructions.modesetting.ModeSettingInstructionRegistry;
import spirv.instructions.constantcreation.ConstantCreationInstructionRegistry;
import spirv.instructions.nonuniform.NonUniformInstructionRegistry;
import spirv.instructions.unclassified.UnclassifiedInstructionRegistry;
import spirv.instructions.debug.DebugInstructionRegistry;
import spirv.instructions.typedeclaration.TypeDeclarationInstructionRegistry;
import spirv.instructions.tensor.TensorInstructionRegistry;
import spirv.instructions.composite.CompositeInstructionRegistry;
import spirv.instructions.relationalandlogical.RelationalandLogicalInstructionRegistry;
import spirv.instructions.controlflow.ControlFlowInstructionRegistry;
import spirv.instructions.pipe.PipeInstructionRegistry;
import spirv.instructions.bit.BitInstructionRegistry;
import spirv.instructions.conversion.ConversionInstructionRegistry;
import spirv.instructions.annotation.AnnotationInstructionRegistry;
import spirv.instructions.extension.ExtensionInstructionRegistry;
import spirv.instructions.graph.GraphInstructionRegistry;
import spirv.instructions.derivative.DerivativeInstructionRegistry;
import spirv.instructions.devicesideenqueue.DeviceSideEnqueueInstructionRegistry;
import spirv.instructions.reserved.ReservedInstructionRegistry;
import spirv.instructions.arithmetic.ArithmeticInstructionRegistry;

import java.util.Map;
import java.util.function.Supplier;

public class InstructionRegistry {

	@SuppressWarnings("unchecked")
	public static final Supplier<Instruction>[] INSTRUCTION_REGISTRY = new Supplier[6532];

	static {
		InstructionRegistry.addAll(GroupInstructionRegistry.GROUP_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(MiscellaneousInstructionRegistry.MISCELLANEOUS_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(MemoryInstructionRegistry.MEMORY_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(AtomicInstructionRegistry.ATOMIC_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(BarrierInstructionRegistry.BARRIER_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(FunctionInstructionRegistry.FUNCTION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(PrimitiveInstructionRegistry.PRIMITIVE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ModeSettingInstructionRegistry.MODESETTING_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(NonUniformInstructionRegistry.NONUNIFORM_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(UnclassifiedInstructionRegistry.UNCLASSIFIED_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(DebugInstructionRegistry.DEBUG_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(TensorInstructionRegistry.TENSOR_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(RelationalandLogicalInstructionRegistry.RELATIONALANDLOGICAL_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ControlFlowInstructionRegistry.CONTROLFLOW_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(PipeInstructionRegistry.PIPE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(BitInstructionRegistry.BIT_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ExtensionInstructionRegistry.EXTENSION_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(GraphInstructionRegistry.GRAPH_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(DerivativeInstructionRegistry.DERIVATIVE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(DeviceSideEnqueueInstructionRegistry.DEVICESIDEENQUEUE_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ReservedInstructionRegistry.RESERVED_INSTRUCTIONS_REGISTRY);
		InstructionRegistry.addAll(ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY);

	}

	public static void addAll(Map<Integer, Supplier<Instruction>> instructionRegistry) {
		for (Map.Entry<Integer, Supplier<Instruction>> opcodeInstruction : instructionRegistry.entrySet()) {
			InstructionRegistry.INSTRUCTION_REGISTRY[opcodeInstruction.getKey()] = opcodeInstruction.getValue();
		}
	}
}
