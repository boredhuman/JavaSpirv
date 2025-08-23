package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpReportIntersectionKHR implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction hit;
	public Instruction hitKind;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.hit = instructions[data[offset + 2]];
		this.hitKind = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.hit);
		writer.write(this.hitKind);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_REPORT_INTERSECTION_KHR;
	}

	@Override
	public Instruction resultType() {
		return this.idResultType;
	}

	@Override
	public void setResultType(Instruction resultType) {
		this.idResultType = resultType;
	}

	@Override
	public int result() {
		return this.idResult;
	}

	@Override
	public void setResult(int result) {
		this.idResult = result;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingNV", "RayTracingKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_ray_tracing", "SPV_KHR_ray_tracing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpReportIntersectionKHR)) {
			return false;
		}
		OpReportIntersectionKHR other = (OpReportIntersectionKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.hit.equals(other.hit)) {
			return false;
		}
		return this.hitKind.equals(other.hitKind);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.hit.hashCode();
		return 31 * result + this.hitKind.hashCode();
	}
}