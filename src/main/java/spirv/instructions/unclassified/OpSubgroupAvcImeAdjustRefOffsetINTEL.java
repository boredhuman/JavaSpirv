package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcImeAdjustRefOffsetINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction refOffset;
	public Instruction srcCoord;
	public Instruction refWindowSize;
	public Instruction imageSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.refOffset = instructions[data[offset + 2]];
		this.srcCoord = instructions[data[offset + 3]];
		this.refWindowSize = instructions[data[offset + 4]];
		this.imageSize = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.refOffset);
		writer.write(this.srcCoord);
		writer.write(this.refWindowSize);
		writer.write(this.imageSize);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_IME_ADJUST_REF_OFFSET_INTEL;
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
		if (!(o instanceof OpSubgroupAvcImeAdjustRefOffsetINTEL)) {
			return false;
		}
		OpSubgroupAvcImeAdjustRefOffsetINTEL other = (OpSubgroupAvcImeAdjustRefOffsetINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.refOffset.equals(other.refOffset)) {
			return false;
		}
		if (!this.srcCoord.equals(other.srcCoord)) {
			return false;
		}
		if (!this.refWindowSize.equals(other.refWindowSize)) {
			return false;
		}
		return this.imageSize.equals(other.imageSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.refOffset.hashCode();
		result += 31 * result + this.srcCoord.hashCode();
		result += 31 * result + this.refWindowSize.hashCode();
		return 31 * result + this.imageSize.hashCode();
	}
}