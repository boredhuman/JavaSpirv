package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcImeGetStreamoutDualReferenceMajorShapeReferenceIdsINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction payload;
	public Instruction majorShape;
	public Instruction direction;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.payload = instructions[data[offset + 2]];
		this.majorShape = instructions[data[offset + 3]];
		this.direction = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.payload);
		writer.write(this.majorShape);
		writer.write(this.direction);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_IME_GET_STREAMOUT_DUAL_REFERENCE_MAJOR_SHAPE_REFERENCE_IDS_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcImeGetStreamoutDualReferenceMajorShapeReferenceIdsINTEL)) {
			return false;
		}
		OpSubgroupAvcImeGetStreamoutDualReferenceMajorShapeReferenceIdsINTEL other = (OpSubgroupAvcImeGetStreamoutDualReferenceMajorShapeReferenceIdsINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.payload.equals(other.payload)) {
			return false;
		}
		if (!this.majorShape.equals(other.majorShape)) {
			return false;
		}
		return this.direction.equals(other.direction);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.payload.hashCode();
		result += 31 * result + this.majorShape.hashCode();
		return 31 * result + this.direction.hashCode();
	}
}