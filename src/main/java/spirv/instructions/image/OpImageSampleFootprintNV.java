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

public class OpImageSampleFootprintNV implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sampledImage;
	public Instruction coordinate;
	public Instruction granularity;
	public Instruction coarse;
	@BitMask(ImageOperands.class)
	public int imageOperands;
	public Instruction[] imageOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sampledImage = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
		this.granularity = instructions[data[offset + 4]];
		this.coarse = instructions[data[offset + 5]];
		if (length - 6 <= 0) {
			return;
		}
		this.imageOperands = data[offset + 6];
		this.imageOperandsArg = new Instruction[ImageOperands.getArgumentCount(this.imageOperands)];
		for (int i = 0; i < this.imageOperandsArg.length; i++) {
			this.imageOperandsArg[i] = instructions[data[offset + 7 + i]];
		}
	}

	@Override
	public int size() {
		int size = 6;
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
		writer.write(this.granularity);
		writer.write(this.coarse);
		if (this.imageOperands > 0) {
			writer.write(this.imageOperands);
			writer.write(this.imageOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_SAMPLE_FOOTPRINT_NV;
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
		 return new String[] { "ImageFootprintNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_shader_image_footprint" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageSampleFootprintNV)) {
			return false;
		}
		OpImageSampleFootprintNV other = (OpImageSampleFootprintNV) o;
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
		if (!this.granularity.equals(other.granularity)) {
			return false;
		}
		if (!this.coarse.equals(other.coarse)) {
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
		result += 31 * result + this.granularity.hashCode();
		result += 31 * result + this.coarse.hashCode();
		result += 31 * result + Objects.hashCode(this.imageOperands);
		return 31 * result + Arrays.hashCode(this.imageOperandsArg);
	}
}