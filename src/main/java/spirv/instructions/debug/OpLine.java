package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpLine implements DebugInstruction {
	public Instruction file;
	public int line;
	public int column;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.file = instructions[data[offset]];
		this.line = data[offset + 1];
		this.column = data[offset + 2];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.file);
		writer.write(this.line);
		writer.write(this.column);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_LINE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpLine)) {
			return false;
		}
		OpLine other = (OpLine) o;
		if (!this.file.equals(other.file)) {
			return false;
		}
		if (this.line != other.line) {
			return false;
		}
		return this.column != other.column;
	}

	@Override
	public int hashCode() {
		int result = this.file.hashCode();
		result += 31 * result + this.line;
		return 31 * result + this.column;
	}
}