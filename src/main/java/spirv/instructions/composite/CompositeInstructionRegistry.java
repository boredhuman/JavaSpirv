package spirv.instructions.composite;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CompositeInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> COMPOSITE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(77, OpVectorExtractDynamic::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(78, OpVectorInsertDynamic::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(79, OpVectorShuffle::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(80, OpCompositeConstruct::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(81, OpCompositeExtract::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(82, OpCompositeInsert::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(83, OpCopyObject::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(84, OpTranspose::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(400, OpCopyLogical::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(4463, OpCompositeConstructReplicateEXT::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(4540, OpCompositeConstructCoopMatQCOM::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(4541, OpCompositeExtractCoopMatQCOM::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(4542, OpExtractSubArrayQCOM::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(6096, OpCompositeConstructContinuedINTEL::new);
		CompositeInstructionRegistry.COMPOSITE_INSTRUCTIONS_REGISTRY.put(6254, OpConditionalCopyObjectINTEL::new);
	}
}