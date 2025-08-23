package spirv.instructions.reserved;

import spirv.instructions.OpCodes;

public class OpTerminateRayNV implements ReservedInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_TERMINATE_RAY_NV;
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
		 return o instanceof OpTerminateRayNV;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_TERMINATE_RAY_NV;
	}
}