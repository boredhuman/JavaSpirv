package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupImageMediaBlockReadINTEL implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction image;
	public Instruction coordinate;
	public Instruction width;
	public Instruction height;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.image = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
		this.width = instructions[data[offset + 4]];
		this.height = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.image);
		writer.write(this.coordinate);
		writer.write(this.width);
		writer.write(this.height);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_IMAGE_MEDIA_BLOCK_READ_INTEL;
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
		 return new String[] { "SubgroupImageMediaBlockIOINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupImageMediaBlockReadINTEL)) {
			return false;
		}
		OpSubgroupImageMediaBlockReadINTEL other = (OpSubgroupImageMediaBlockReadINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.image.equals(other.image)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		if (!this.width.equals(other.width)) {
			return false;
		}
		return this.height.equals(other.height);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		result += 31 * result + this.width.hashCode();
		return 31 * result + this.height.hashCode();
	}
}