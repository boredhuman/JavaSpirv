package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcMceGetDefaultInterShapePenaltyINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sliceType;
	public Instruction qp;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sliceType = instructions[data[offset + 2]];
		this.qp = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.sliceType);
		writer.write(this.qp);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_MCE_GET_DEFAULT_INTER_SHAPE_PENALTY_INTEL;
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
		if (!(o instanceof OpSubgroupAvcMceGetDefaultInterShapePenaltyINTEL)) {
			return false;
		}
		OpSubgroupAvcMceGetDefaultInterShapePenaltyINTEL other = (OpSubgroupAvcMceGetDefaultInterShapePenaltyINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.sliceType.equals(other.sliceType)) {
			return false;
		}
		return this.qp.equals(other.qp);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.sliceType.hashCode();
		return 31 * result + this.qp.hashCode();
	}
}