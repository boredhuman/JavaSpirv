package spirv.instructions.annotation;

import java.util.Arrays;
import spirv.enumerants.Decoration;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMemberDecorateString implements AnnotationInstruction {
	public Instruction structType;
	public int member;
	public Decoration decoration;
	public Object[] decorationArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.structType = instructions[data[offset]];
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
		writer.write(this.structType);
		writer.write(this.member);
		writer.write(this.decoration);
		if (this.decoration.argumentCount > 0) {
			writer.write(this.decorationArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMBER_DECORATE_STRING;
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_GOOGLE_decorate_string", "SPV_GOOGLE_hlsl_functionality1" };
	}

	@Override
	public String version() {
		return "1.4";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemberDecorateString)) {
			return false;
		}
		OpMemberDecorateString other = (OpMemberDecorateString) o;
		if (!this.structType.equals(other.structType)) {
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
		int result = this.structType.hashCode();
		result += 31 * result + this.member;
		result += 31 * result + this.decoration.hashCode();
		return 31 * result + Arrays.hashCode(this.decorationArg);
	}
}