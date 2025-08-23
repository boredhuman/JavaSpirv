package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcImeSetSingleReferenceINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction refOffset;
	public Instruction searchWindowConfig;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.refOffset = instructions[data[offset + 2]];
		this.searchWindowConfig = instructions[data[offset + 3]];
		this.payload = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.refOffset);
		writer.write(this.searchWindowConfig);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_IME_SET_SINGLE_REFERENCE_INTEL;
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
		if (!(o instanceof OpSubgroupAvcImeSetSingleReferenceINTEL)) {
			return false;
		}
		OpSubgroupAvcImeSetSingleReferenceINTEL other = (OpSubgroupAvcImeSetSingleReferenceINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.refOffset.equals(other.refOffset)) {
			return false;
		}
		if (!this.searchWindowConfig.equals(other.searchWindowConfig)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.refOffset.hashCode();
		result += 31 * result + this.searchWindowConfig.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}