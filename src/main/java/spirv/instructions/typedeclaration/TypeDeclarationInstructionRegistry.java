package spirv.instructions.typedeclaration;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TypeDeclarationInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> TYPEDECLARATION_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(19, OpTypeVoid::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(20, OpTypeBool::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(21, OpTypeInt::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(22, OpTypeFloat::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(23, OpTypeVector::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(24, OpTypeMatrix::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(25, OpTypeImage::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(26, OpTypeSampler::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(27, OpTypeSampledImage::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(28, OpTypeArray::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(29, OpTypeRuntimeArray::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(30, OpTypeStruct::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(31, OpTypeOpaque::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(32, OpTypePointer::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(33, OpTypeFunction::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(34, OpTypeEvent::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(35, OpTypeDeviceEvent::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(36, OpTypeReserveId::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(37, OpTypeQueue::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(38, OpTypePipe::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(39, OpTypeForwardPointer::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(322, OpTypePipeStorage::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(327, OpTypeNamedBarrier::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(4163, OpTypeTensorARM::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(4190, OpTypeGraphARM::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(4417, OpTypeUntypedPointerKHR::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(4456, OpTypeCooperativeMatrixKHR::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(4472, OpTypeRayQueryKHR::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5281, OpTypeHitObjectNV::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5288, OpTypeCooperativeVectorNV::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5341, OpTypeAccelerationStructureKHR::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5358, OpTypeCooperativeMatrixNV::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5370, OpTypeTensorLayoutNV::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(5371, OpTypeTensorViewNV::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(6086, OpTypeBufferSurfaceINTEL::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(6090, OpTypeStructContinuedINTEL::new);
		TypeDeclarationInstructionRegistry.TYPEDECLARATION_INSTRUCTIONS_REGISTRY.put(6199, OpTypeTaskSequenceINTEL::new);
	}
}