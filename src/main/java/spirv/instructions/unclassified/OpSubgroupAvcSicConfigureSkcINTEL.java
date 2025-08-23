package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicConfigureSkcINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction skipBlockPartitionType;
	public Instruction skipMotionVectorMask;
	public Instruction motionVectors;
	public Instruction bidirectionalWeight;
	public Instruction sadAdjustment;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.skipBlockPartitionType = instructions[data[offset + 2]];
		this.skipMotionVectorMask = instructions[data[offset + 3]];
		this.motionVectors = instructions[data[offset + 4]];
		this.bidirectionalWeight = instructions[data[offset + 5]];
		this.sadAdjustment = instructions[data[offset + 6]];
		this.payload = instructions[data[offset + 7]];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.skipBlockPartitionType);
		writer.write(this.skipMotionVectorMask);
		writer.write(this.motionVectors);
		writer.write(this.bidirectionalWeight);
		writer.write(this.sadAdjustment);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_CONFIGURE_SKC_INTEL;
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
		if (!(o instanceof OpSubgroupAvcSicConfigureSkcINTEL)) {
			return false;
		}
		OpSubgroupAvcSicConfigureSkcINTEL other = (OpSubgroupAvcSicConfigureSkcINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.skipBlockPartitionType.equals(other.skipBlockPartitionType)) {
			return false;
		}
		if (!this.skipMotionVectorMask.equals(other.skipMotionVectorMask)) {
			return false;
		}
		if (!this.motionVectors.equals(other.motionVectors)) {
			return false;
		}
		if (!this.bidirectionalWeight.equals(other.bidirectionalWeight)) {
			return false;
		}
		if (!this.sadAdjustment.equals(other.sadAdjustment)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.skipBlockPartitionType.hashCode();
		result += 31 * result + this.skipMotionVectorMask.hashCode();
		result += 31 * result + this.motionVectors.hashCode();
		result += 31 * result + this.bidirectionalWeight.hashCode();
		result += 31 * result + this.sadAdjustment.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}