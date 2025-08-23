package spirv.instructions.reserved;

import spirv.instructions.OpCodes;

public class OpTerminateRayKHR implements ReservedInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_TERMINATE_RAY_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_ray_tracing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpTerminateRayKHR;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_TERMINATE_RAY_KHR;
	}
}