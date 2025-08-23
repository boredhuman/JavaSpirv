package spirv.instructions.atomic;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpAtomicFlagClear implements AtomicInstruction {
	public Instruction pointer;
	public Instruction memory;
	public Instruction semantics;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.memory = instructions[data[offset + 1]];
		this.semantics = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.memory);
		writer.write(this.semantics);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ATOMIC_FLAG_CLEAR;
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
		if (!(o instanceof OpAtomicFlagClear)) {
			return false;
		}
		OpAtomicFlagClear other = (OpAtomicFlagClear) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		return this.semantics.equals(other.semantics);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.memory.hashCode();
		return 31 * result + this.semantics.hashCode();
	}
}