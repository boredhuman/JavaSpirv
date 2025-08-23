package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicSetIntraLumaModeCostFunctionINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction lumaModePenalty;
	public Instruction lumaPackedNeighborModes;
	public Instruction lumaPackedNonDcPenalty;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.lumaModePenalty = instructions[data[offset + 2]];
		this.lumaPackedNeighborModes = instructions[data[offset + 3]];
		this.lumaPackedNonDcPenalty = instructions[data[offset + 4]];
		this.payload = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.lumaModePenalty);
		writer.write(this.lumaPackedNeighborModes);
		writer.write(this.lumaPackedNonDcPenalty);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_SET_INTRA_LUMA_MODE_COST_FUNCTION_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL", "SubgroupAvcMotionEstimationIntraINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcSicSetIntraLumaModeCostFunctionINTEL)) {
			return false;
		}
		OpSubgroupAvcSicSetIntraLumaModeCostFunctionINTEL other = (OpSubgroupAvcSicSetIntraLumaModeCostFunctionINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.lumaModePenalty.equals(other.lumaModePenalty)) {
			return false;
		}
		if (!this.lumaPackedNeighborModes.equals(other.lumaPackedNeighborModes)) {
			return false;
		}
		if (!this.lumaPackedNonDcPenalty.equals(other.lumaPackedNonDcPenalty)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.lumaModePenalty.hashCode();
		result += 31 * result + this.lumaPackedNeighborModes.hashCode();
		result += 31 * result + this.lumaPackedNonDcPenalty.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}