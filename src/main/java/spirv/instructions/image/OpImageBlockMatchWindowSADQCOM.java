package spirv.instructions.image;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpImageBlockMatchWindowSADQCOM implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction targetSampledImage;
	public Instruction targetCoordinates;
	public Instruction referenceSampledImage;
	public Instruction referenceCoordinates;
	public Instruction blockSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.targetSampledImage = instructions[data[offset + 2]];
		this.targetCoordinates = instructions[data[offset + 3]];
		this.referenceSampledImage = instructions[data[offset + 4]];
		this.referenceCoordinates = instructions[data[offset + 5]];
		this.blockSize = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.targetSampledImage);
		writer.write(this.targetCoordinates);
		writer.write(this.referenceSampledImage);
		writer.write(this.referenceCoordinates);
		writer.write(this.blockSize);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_BLOCK_MATCH_WINDOW_SADQCOM;
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
		 return new String[] { "TextureBlockMatch2QCOM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageBlockMatchWindowSADQCOM)) {
			return false;
		}
		OpImageBlockMatchWindowSADQCOM other = (OpImageBlockMatchWindowSADQCOM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.targetSampledImage.equals(other.targetSampledImage)) {
			return false;
		}
		if (!this.targetCoordinates.equals(other.targetCoordinates)) {
			return false;
		}
		if (!this.referenceSampledImage.equals(other.referenceSampledImage)) {
			return false;
		}
		if (!this.referenceCoordinates.equals(other.referenceCoordinates)) {
			return false;
		}
		return this.blockSize.equals(other.blockSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.targetSampledImage.hashCode();
		result += 31 * result + this.targetCoordinates.hashCode();
		result += 31 * result + this.referenceSampledImage.hashCode();
		result += 31 * result + this.referenceCoordinates.hashCode();
		return 31 * result + this.blockSize.hashCode();
	}
}