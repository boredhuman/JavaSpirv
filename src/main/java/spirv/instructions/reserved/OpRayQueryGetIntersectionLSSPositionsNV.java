package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpRayQueryGetIntersectionLSSPositionsNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction rayQuery;
	public Instruction intersection;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.rayQuery = instructions[data[offset + 2]];
		this.intersection = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.rayQuery);
		writer.write(this.intersection);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RAY_QUERY_GET_INTERSECTION_LSS_POSITIONS_NV;
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
		 return new String[] { "RayTracingLinearSweptSpheresGeometryNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpRayQueryGetIntersectionLSSPositionsNV)) {
			return false;
		}
		OpRayQueryGetIntersectionLSSPositionsNV other = (OpRayQueryGetIntersectionLSSPositionsNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.rayQuery.equals(other.rayQuery)) {
			return false;
		}
		return this.intersection.equals(other.intersection);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.rayQuery.hashCode();
		return 31 * result + this.intersection.hashCode();
	}
}