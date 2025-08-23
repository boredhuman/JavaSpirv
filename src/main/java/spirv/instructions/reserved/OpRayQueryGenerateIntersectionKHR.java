package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpRayQueryGenerateIntersectionKHR implements ReservedInstruction {
	public Instruction rayQuery;
	public Instruction hitT;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.rayQuery = instructions[data[offset]];
		this.hitT = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.rayQuery);
		writer.write(this.hitT);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RAY_QUERY_GENERATE_INTERSECTION_KHR;
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
		if (!(o instanceof OpRayQueryGenerateIntersectionKHR)) {
			return false;
		}
		OpRayQueryGenerateIntersectionKHR other = (OpRayQueryGenerateIntersectionKHR) o;
		if (!this.rayQuery.equals(other.rayQuery)) {
			return false;
		}
		return this.hitT.equals(other.hitT);
	}

	@Override
	public int hashCode() {
		int result = this.rayQuery.hashCode();
		return 31 * result + this.hitT.hashCode();
	}
}