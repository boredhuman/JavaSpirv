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

public class OpImageGather implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sampledImage;
	public Instruction coordinate;
	public Instruction component;
	@BitMask(ImageOperands.class)
	public int imageOperands;
	public Instruction[] imageOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sampledImage = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
		this.component = instructions[data[offset + 4]];
		if (length - 5 <= 0) {
			return;
		}
		this.imageOperands = data[offset + 5];
		this.imageOperandsArg = new Instruction[ImageOperands.getArgumentCount(this.imageOperands)];
		for (int i = 0; i < this.imageOperandsArg.length; i++) {
			this.imageOperandsArg[i] = instructions[data[offset + 6 + i]];
		}
	}

	@Override
	public int size() {
		int size = 5;
		size += this.imageOperands == 0 ? 0 : 1;
		size += ImageOperands.getArgumentCount(this.imageOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.sampledImage);
		writer.write(this.coordinate);
		writer.write(this.component);
		if (this.imageOperands > 0) {
			writer.write(this.imageOperands);
			writer.write(this.imageOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_GATHER;
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
		 return new String[] { "Shader" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageGather)) {
			return false;
		}
		OpImageGather other = (OpImageGather) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.sampledImage.equals(other.sampledImage)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		if (!this.component.equals(other.component)) {
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
		result += 31 * result + this.sampledImage.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		result += 31 * result + this.component.hashCode();
		result += 31 * result + Objects.hashCode(this.imageOperands);
		return 31 * result + Arrays.hashCode(this.imageOperandsArg);
	}
}