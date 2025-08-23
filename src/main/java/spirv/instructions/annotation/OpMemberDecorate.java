package spirv.instructions.annotation;

import java.util.Arrays;
import spirv.enumerants.Decoration;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMemberDecorate implements AnnotationInstruction {
	public Instruction structureType;
	public int member;
	public Decoration decoration;
	public Object[] decorationArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.structureType = instructions[data[offset]];
		this.member = data[offset + 1];
		this.decoration = Decoration.get(data[offset + 2]);
		this.decorationArg = this.decoration.loadArg(data, offset + 3, instructions);
	}

	@Override
	public int size() {
		int size = 3;
		size += this.decoration.size(this.decorationArg);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.structureType);
		writer.write(this.member);
		writer.write(this.decoration);
		if (this.decoration.argumentCount > 0) {
			writer.write(this.decorationArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMBER_DECORATE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemberDecorate)) {
			return false;
		}
		OpMemberDecorate other = (OpMemberDecorate) o;
		if (!this.structureType.equals(other.structureType)) {
			return false;
		}
		if (this.member != other.member) {
			return false;
		}
		if (this.decoration != other.decoration) {
			return false;
		}
		return Arrays.equals(this.decorationArg, other.decorationArg);
	}

	@Override
	public int hashCode() {
		int result = this.structureType.hashCode();
		result += 31 * result + this.member;
		result += 31 * result + this.decoration.hashCode();
		return 31 * result + Arrays.hashCode(this.decorationArg);
	}
}