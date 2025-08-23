package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicEvaluateWithMultiReferenceInterlacedINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction srcImage;
	public Instruction packedReferenceIds;
	public Instruction packedReferenceFieldPolarities;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.srcImage = instructions[data[offset + 2]];
		this.packedReferenceIds = instructions[data[offset + 3]];
		this.packedReferenceFieldPolarities = instructions[data[offset + 4]];
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
		writer.write(this.packedReferenceIds);
		writer.write(this.packedReferenceFieldPolarities);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_EVALUATE_WITH_MULTI_REFERENCE_INTERLACED_INTEL;
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
		if (!(o instanceof OpSubgroupAvcSicEvaluateWithMultiReferenceInterlacedINTEL)) {
			return false;
		}
		OpSubgroupAvcSicEvaluateWithMultiReferenceInterlacedINTEL other = (OpSubgroupAvcSicEvaluateWithMultiReferenceInterlacedINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.srcImage.equals(other.srcImage)) {
			return false;
		}
		if (!this.packedReferenceIds.equals(other.packedReferenceIds)) {
			return false;
		}
		if (!this.packedReferenceFieldPolarities.equals(other.packedReferenceFieldPolarities)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.srcImage.hashCode();
		result += 31 * result + this.packedReferenceIds.hashCode();
		result += 31 * result + this.packedReferenceFieldPolarities.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}