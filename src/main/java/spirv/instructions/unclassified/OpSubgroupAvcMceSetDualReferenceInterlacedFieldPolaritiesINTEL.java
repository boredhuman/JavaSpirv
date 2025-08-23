package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcMceSetDualReferenceInterlacedFieldPolaritiesINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction forwardReferenceFieldPolarity;
	public Instruction backwardReferenceFieldPolarity;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.forwardReferenceFieldPolarity = instructions[data[offset + 2]];
		this.backwardReferenceFieldPolarity = instructions[data[offset + 3]];
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
		writer.write(this.forwardReferenceFieldPolarity);
		writer.write(this.backwardReferenceFieldPolarity);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_MCE_SET_DUAL_REFERENCE_INTERLACED_FIELD_POLARITIES_INTEL;
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
		if (!(o instanceof OpSubgroupAvcMceSetDualReferenceInterlacedFieldPolaritiesINTEL)) {
			return false;
		}
		OpSubgroupAvcMceSetDualReferenceInterlacedFieldPolaritiesINTEL other = (OpSubgroupAvcMceSetDualReferenceInterlacedFieldPolaritiesINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.forwardReferenceFieldPolarity.equals(other.forwardReferenceFieldPolarity)) {
			return false;
		}
		if (!this.backwardReferenceFieldPolarity.equals(other.backwardReferenceFieldPolarity)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.forwardReferenceFieldPolarity.hashCode();
		result += 31 * result + this.backwardReferenceFieldPolarity.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}