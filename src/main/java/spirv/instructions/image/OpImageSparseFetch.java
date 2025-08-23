package spirv.instructions.image;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.ImageOperands;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpImageSparseFetch implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction image;
	public Instruction coordinate;
	@BitMask(ImageOperands.class)
	public int imageOperands;
	public Instruction[] imageOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.image = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.imageOperands = data[offset + 4];
		this.imageOperandsArg = new Instruction[ImageOperands.getArgumentCount(this.imageOperands)];
		for (int i = 0; i < this.imageOperandsArg.length; i++) {
			this.imageOperandsArg[i] = instructions[data[offset + 5 + i]];
		}
	}

	@Override
	public int size() {
		int size = 4;
		size += this.imageOperands == 0 ? 0 : 1;
		size += ImageOperands.getArgumentCount(this.imageOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.image);
		writer.write(this.coordinate);
		if (this.imageOperands > 0) {
			writer.write(this.imageOperands);
			writer.write(this.imageOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_SPARSE_FETCH;
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
		 return new String[] { "SparseResidency" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageSparseFetch)) {
			return false;
		}
		OpImageSparseFetch other = (OpImageSparseFetch) o;
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
		if (!Objects.equals(this.imageOperands, other.imageOperands)) {
			return false;
		}
		return Arrays.equals(this.imageOperandsArg, other.imageOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		result += 31 * result + Objects.hashCode(this.imageOperands);
		return 31 * result + Arrays.hashCode(this.imageOperandsArg);
	}
}