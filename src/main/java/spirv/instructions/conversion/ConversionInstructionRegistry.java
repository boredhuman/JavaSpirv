package spirv.instructions.conversion;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConversionInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> CONVERSION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(109, OpConvertFToU::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(110, OpConvertFToS::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(111, OpConvertSToF::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(112, OpConvertUToF::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(113, OpUConvert::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(114, OpSConvert::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(115, OpFConvert::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(116, OpQuantizeToF16::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(117, OpConvertPtrToU::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(118, OpSatConvertSToU::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(119, OpSatConvertUToS::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(120, OpConvertUToPtr::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(121, OpPtrCastToGeneric::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(122, OpGenericCastToPtr::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(123, OpGenericCastToPtrExplicit::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(124, OpBitcast::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(4497, OpBitCastArrayQCOM::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(5293, OpCooperativeMatrixConvertNV::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(5390, OpCooperativeMatrixTransposeNV::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(6116, OpConvertFToBF16INTEL::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(6117, OpConvertBF16ToFINTEL::new);
		ConversionInstructionRegistry.CONVERSION_INSTRUCTIONS_REGISTRY.put(6426, OpRoundFToTF32INTEL::new);
	}
}