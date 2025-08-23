package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpName implements DebugInstruction {
	public Instruction target;
	public String name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.target = instructions[data[offset]];
		this.name = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.name);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.target);
		writer.write(this.name);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_NAME;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpName)) {
			return false;
		}
		OpName other = (OpName) o;
		if (!this.target.equals(other.target)) {
			return false;
		}
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		int result = this.target.hashCode();
		return 31 * result + this.name.hashCode();
	}
}