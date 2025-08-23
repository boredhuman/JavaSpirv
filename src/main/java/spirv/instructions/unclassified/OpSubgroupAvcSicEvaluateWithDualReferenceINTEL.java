package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicEvaluateWithDualReferenceINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction srcImage;
	public Instruction fwdRefImage;
	public Instruction bwdRefImage;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.srcImage = instructions[data[offset + 2]];
		this.fwdRefImage = instructions[data[offset + 3]];
		this.bwdRefImage = instructions[data[offset + 4]];
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
		writer.write(this.srcImage);
		writer.write(this.fwdRefImage);
		writer.write(this.bwdRefImage);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_EVALUATE_WITH_DUAL_REFERENCE_INTEL;
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
		if (!(o instanceof OpSubgroupAvcSicEvaluateWithDualReferenceINTEL)) {
			return false;
		}
		OpSubgroupAvcSicEvaluateWithDualReferenceINTEL other = (OpSubgroupAvcSicEvaluateWithDualReferenceINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.srcImage.equals(other.srcImage)) {
			return false;
		}
		if (!this.fwdRefImage.equals(other.fwdRefImage)) {
			return false;
		}
		if (!this.bwdRefImage.equals(other.bwdRefImage)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.srcImage.hashCode();
		result += 31 * result + this.fwdRefImage.hashCode();
		result += 31 * result + this.bwdRefImage.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}