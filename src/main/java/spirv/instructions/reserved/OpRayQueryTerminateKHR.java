package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpRayQueryTerminateKHR implements ReservedInstruction {
	public Instruction rayQuery;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.rayQuery = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.rayQuery);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RAY_QUERY_TERMINATE_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayQueryKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_ray_query" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpRayQueryTerminateKHR)) {
			return false;
		}
		OpRayQueryTerminateKHR other = (OpRayQueryTerminateKHR) o;
		return this.rayQuery.equals(other.rayQuery);
	}

	@Override
	public int hashCode() {
		return this.rayQuery.hashCode();
	}
}