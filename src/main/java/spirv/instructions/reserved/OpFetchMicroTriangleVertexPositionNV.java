package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpFetchMicroTriangleVertexPositionNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction accel;
	public Instruction instanceId;
	public Instruction geometryIndex;
	public Instruction primitiveIndex;
	public Instruction barycentric;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.accel = instructions[data[offset + 2]];
		this.instanceId = instructions[data[offset + 3]];
		this.geometryIndex = instructions[data[offset + 4]];
		this.primitiveIndex = instructions[data[offset + 5]];
		this.barycentric = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.accel);
		writer.write(this.instanceId);
		writer.write(this.geometryIndex);
		writer.write(this.primitiveIndex);
		writer.write(this.barycentric);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_FETCH_MICRO_TRIANGLE_VERTEX_POSITION_NV;
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
		 return new String[] { "DisplacementMicromapNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpFetchMicroTriangleVertexPositionNV)) {
			return false;
		}
		OpFetchMicroTriangleVertexPositionNV other = (OpFetchMicroTriangleVertexPositionNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.accel.equals(other.accel)) {
			return false;
		}
		if (!this.instanceId.equals(other.instanceId)) {
			return false;
		}
		if (!this.geometryIndex.equals(other.geometryIndex)) {
			return false;
		}
		if (!this.primitiveIndex.equals(other.primitiveIndex)) {
			return false;
		}
		return this.barycentric.equals(other.barycentric);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.accel.hashCode();
		result += 31 * result + this.instanceId.hashCode();
		result += 31 * result + this.geometryIndex.hashCode();
		result += 31 * result + this.primitiveIndex.hashCode();
		return 31 * result + this.barycentric.hashCode();
	}
}