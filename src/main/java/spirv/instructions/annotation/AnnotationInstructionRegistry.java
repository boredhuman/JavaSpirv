package spirv.instructions.annotation;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnnotationInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> ANNOTATION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(71, OpDecorate::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(72, OpMemberDecorate::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(73, OpDecorationGroup::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(74, OpGroupDecorate::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(75, OpGroupMemberDecorate::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(332, OpDecorateId::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(5632, OpDecorateString::new);
		AnnotationInstructionRegistry.ANNOTATION_INSTRUCTIONS_REGISTRY.put(5633, OpMemberDecorateString::new);
	}
}