package spirv.instructions.reserved;

import spirv.instructions.OpCodes;

public class OpIgnoreIntersectionNV implements ReservedInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_IGNORE_INTERSECTION_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_ray_tracing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpIgnoreIntersectionNV;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_IGNORE_INTERSECTION_NV;
	}
}