package spirv.instructions.image;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ImageInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> IMAGE_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(86, OpSampledImage::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(87, OpImageSampleImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(88, OpImageSampleExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(89, OpImageSampleDrefImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(90, OpImageSampleDrefExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(91, OpImageSampleProjImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(92, OpImageSampleProjExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(93, OpImageSampleProjDrefImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(94, OpImageSampleProjDrefExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(95, OpImageFetch::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(96, OpImageGather::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(97, OpImageDrefGather::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(98, OpImageRead::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(99, OpImageWrite::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(100, OpImage::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(101, OpImageQueryFormat::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(102, OpImageQueryOrder::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(103, OpImageQuerySizeLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(104, OpImageQuerySize::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(105, OpImageQueryLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(106, OpImageQueryLevels::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(107, OpImageQuerySamples::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(305, OpImageSparseSampleImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(306, OpImageSparseSampleExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(307, OpImageSparseSampleDrefImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(308, OpImageSparseSampleDrefExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(309, OpImageSparseSampleProjImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(310, OpImageSparseSampleProjExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(311, OpImageSparseSampleProjDrefImplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(312, OpImageSparseSampleProjDrefExplicitLod::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(313, OpImageSparseFetch::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(314, OpImageSparseGather::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(315, OpImageSparseDrefGather::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(316, OpImageSparseTexelsResident::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(320, OpImageSparseRead::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4160, OpColorAttachmentReadEXT::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4161, OpDepthAttachmentReadEXT::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4162, OpStencilAttachmentReadEXT::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4480, OpImageSampleWeightedQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4481, OpImageBoxFilterQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4482, OpImageBlockMatchSSDQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4483, OpImageBlockMatchSADQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4500, OpImageBlockMatchWindowSSDQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4501, OpImageBlockMatchWindowSADQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4502, OpImageBlockMatchGatherSSDQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(4503, OpImageBlockMatchGatherSADQCOM::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(5283, OpImageSampleFootprintNV::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(6529, OpConvertHandleToImageINTEL::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(6530, OpConvertHandleToSamplerINTEL::new);
		ImageInstructionRegistry.IMAGE_INSTRUCTIONS_REGISTRY.put(6531, OpConvertHandleToSampledImageINTEL::new);
	}
}