package spirv.instructions.constantcreation;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConstantCreationInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> CONSTANTCREATION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(41, OpConstantTrue::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(42, OpConstantFalse::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(43, OpConstant::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(44, OpConstantComposite::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(45, OpConstantSampler::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(46, OpConstantNull::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(48, OpSpecConstantTrue::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(49, OpSpecConstantFalse::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(50, OpSpecConstant::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(51, OpSpecConstantComposite::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(52, OpSpecConstantOp::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(4461, OpConstantCompositeReplicateEXT::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(4462, OpSpecConstantCompositeReplicateEXT::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(6091, OpConstantCompositeContinuedINTEL::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(6092, OpSpecConstantCompositeContinuedINTEL::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(6251, OpSpecConstantTargetINTEL::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(6252, OpSpecConstantArchitectureINTEL::new);
		ConstantCreationInstructionRegistry.CONSTANTCREATION_INSTRUCTIONS_REGISTRY.put(6253, OpSpecConstantCapabilitiesINTEL::new);
	}
}