package spirv.instructions.image;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpImageQueryLod implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sampledImage;
	public Instruction coordinate;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sampledImage = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.sampledImage);
		writer.write(this.coordinate);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_QUERY_LOD;
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
		 return new String[] { "ImageQuery" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageQueryLod)) {
			return false;
		}
		OpImageQueryLod other = (OpImageQueryLod) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.sampledImage.equals(other.sampledImage)) {
			return false;
		}
		return this.coordinate.equals(other.coordinate);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.sampledImage.hashCode();
		return 31 * result + this.coordinate.hashCode();
	}
}