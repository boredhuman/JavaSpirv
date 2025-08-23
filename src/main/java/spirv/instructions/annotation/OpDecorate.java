package spirv.instructions.annotation;

import java.util.Arrays;
import spirv.enumerants.Decoration;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpDecorate implements AnnotationInstruction {
	public Instruction target;
	public Decoration decoration;
	public Object[] decorationArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.target = instructions[data[offset]];
		this.decoration = Decoration.get(data[offset + 1]);
		this.decorationArg = this.decoration.loadArg(data, offset + 2, instructions);
	}

	@Override
	public int size() {
		int size = 2;
		size += this.decoration.size(this.decorationArg);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.target);
		writer.write(this.decoration);
		if (this.decoration.argumentCount > 0) {
			writer.write(this.decorationArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_DECORATE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpDecorate)) {
			return false;
		}
		OpDecorate other = (OpDecorate) o;
		if (!this.target.equals(other.target)) {
			return false;
		}
		if (this.decoration != other.decoration) {
			return false;
		}
		return Arrays.equals(this.decorationArg, other.decorationArg);
	}

	@Override
	public int hashCode() {
		int result = this.target.hashCode();
		result += 31 * result + this.decoration.hashCode();
		return 31 * result + Arrays.hashCode(this.decorationArg);
	}
}