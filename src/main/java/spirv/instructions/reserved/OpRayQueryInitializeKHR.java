package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpRayQueryInitializeKHR implements ReservedInstruction {
	public Instruction rayQuery;
	public Instruction accel;
	public Instruction rayFlags;
	public Instruction cullMask;
	public Instruction rayOrigin;
	public Instruction rayTMin;
	public Instruction rayDirection;
	public Instruction rayTMax;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.rayQuery = instructions[data[offset]];
		this.accel = instructions[data[offset + 1]];
		this.rayFlags = instructions[data[offset + 2]];
		this.cullMask = instructions[data[offset + 3]];
		this.rayOrigin = instructions[data[offset + 4]];
		this.rayTMin = instructions[data[offset + 5]];
		this.rayDirection = instructions[data[offset + 6]];
		this.rayTMax = instructions[data[offset + 7]];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.rayQuery);
		writer.write(this.accel);
		writer.write(this.rayFlags);
		writer.write(this.cullMask);
		writer.write(this.rayOrigin);
		writer.write(this.rayTMin);
		writer.write(this.rayDirection);
		writer.write(this.rayTMax);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RAY_QUERY_INITIALIZE_KHR;
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
		if (!(o instanceof OpRayQueryInitializeKHR)) {
			return false;
		}
		OpRayQueryInitializeKHR other = (OpRayQueryInitializeKHR) o;
		if (!this.rayQuery.equals(other.rayQuery)) {
			return false;
		}
		if (!this.accel.equals(other.accel)) {
			return false;
		}
		if (!this.rayFlags.equals(other.rayFlags)) {
			return false;
		}
		if (!this.cullMask.equals(other.cullMask)) {
			return false;
		}
		if (!this.rayOrigin.equals(other.rayOrigin)) {
			return false;
		}
		if (!this.rayTMin.equals(other.rayTMin)) {
			return false;
		}
		if (!this.rayDirection.equals(other.rayDirection)) {
			return false;
		}
		return this.rayTMax.equals(other.rayTMax);
	}

	@Override
	public int hashCode() {
		int result = this.rayQuery.hashCode();
		result += 31 * result + this.accel.hashCode();
		result += 31 * result + this.rayFlags.hashCode();
		result += 31 * result + this.cullMask.hashCode();
		result += 31 * result + this.rayOrigin.hashCode();
		result += 31 * result + this.rayTMin.hashCode();
		result += 31 * result + this.rayDirection.hashCode();
		return 31 * result + this.rayTMax.hashCode();
	}
}