package spirv.instructions.controlflow;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpLifetimeStart implements ControlFlowInstruction {
	public Instruction pointer;
	public int size;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.size = data[offset + 1];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.size);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_LIFETIME_START;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Kernel" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpLifetimeStart)) {
			return false;
		}
		OpLifetimeStart other = (OpLifetimeStart) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		return this.size != other.size;
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		return 31 * result + this.size;
	}
}