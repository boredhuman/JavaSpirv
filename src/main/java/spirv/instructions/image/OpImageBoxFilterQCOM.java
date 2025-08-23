package spirv.instructions.image;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpImageBoxFilterQCOM implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction texture;
	public Instruction coordinates;
	public Instruction boxSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.texture = instructions[data[offset + 2]];
		this.coordinates = instructions[data[offset + 3]];
		this.boxSize = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.texture);
		writer.write(this.coordinates);
		writer.write(this.boxSize);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_BOX_FILTER_QCOM;
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
		 return new String[] { "TextureBoxFilterQCOM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageBoxFilterQCOM)) {
			return false;
		}
		OpImageBoxFilterQCOM other = (OpImageBoxFilterQCOM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.texture.equals(other.texture)) {
			return false;
		}
		if (!this.coordinates.equals(other.coordinates)) {
			return false;
		}
		return this.boxSize.equals(other.boxSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.texture.hashCode();
		result += 31 * result + this.coordinates.hashCode();
		return 31 * result + this.boxSize.hashCode();
	}
}