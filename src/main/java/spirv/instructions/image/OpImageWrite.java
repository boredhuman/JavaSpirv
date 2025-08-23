package spirv.instructions.image;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.ImageOperands;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpImageWrite implements ImageInstruction {
	public Instruction image;
	public Instruction coordinate;
	public Instruction texel;
	@BitMask(ImageOperands.class)
	public int imageOperands;
	public Instruction[] imageOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.image = instructions[data[offset]];
		this.coordinate = instructions[data[offset + 1]];
		this.texel = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.imageOperands = data[offset + 3];
		this.imageOperandsArg = new Instruction[ImageOperands.getArgumentCount(this.imageOperands)];
		for (int i = 0; i < this.imageOperandsArg.length; i++) {
			this.imageOperandsArg[i] = instructions[data[offset + 4 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.imageOperands == 0 ? 0 : 1;
		size += ImageOperands.getArgumentCount(this.imageOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.image);
		writer.write(this.coordinate);
		writer.write(this.texel);
		if (this.imageOperands > 0) {
			writer.write(this.imageOperands);
			writer.write(this.imageOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IMAGE_WRITE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpImageWrite)) {
			return false;
		}
		OpImageWrite other = (OpImageWrite) o;
		if (!this.image.equals(other.image)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		if (!this.texel.equals(other.texel)) {
			return false;
		}
		if (!Objects.equals(this.imageOperands, other.imageOperands)) {
			return false;
		}
		return Arrays.equals(this.imageOperandsArg, other.imageOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		result += 31 * result + this.texel.hashCode();
		result += 31 * result + Objects.hashCode(this.imageOperands);
		return 31 * result + Arrays.hashCode(this.imageOperandsArg);
	}
}