package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpMemberName implements DebugInstruction {
	public Instruction type;
	public int member;
	public String name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.type = instructions[data[offset]];
		this.member = data[offset + 1];
		this.name = InstructionUtil.readString(data, offset + 2).getString();
	}

	@Override
	public int size() {
		int size = 2;
		size += InstructionUtil.wordCount(this.name);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.type);
		writer.write(this.member);
		writer.write(this.name);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMBER_NAME;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemberName)) {
			return false;
		}
		OpMemberName other = (OpMemberName) o;
		if (!this.type.equals(other.type)) {
			return false;
		}
		if (this.member != other.member) {
			return false;
		}
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		int result = this.type.hashCode();
		result += 31 * result + this.member;
		return 31 * result + this.name.hashCode();
	}
}