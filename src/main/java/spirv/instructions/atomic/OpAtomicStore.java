package spirv.instructions.atomic;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpAtomicStore implements AtomicInstruction {
	public Instruction pointer;
	public Instruction memory;
	public Instruction semantics;
	public Instruction value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.memory = instructions[data[offset + 1]];
		this.semantics = instructions[data[offset + 2]];
		this.value = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.memory);
		writer.write(this.semantics);
		writer.write(this.value);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ATOMIC_STORE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAtomicStore)) {
			return false;
		}
		OpAtomicStore other = (OpAtomicStore) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		if (!this.semantics.equals(other.semantics)) {
			return false;
		}
		return this.value.equals(other.value);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.memory.hashCode();
		result += 31 * result + this.semantics.hashCode();
		return 31 * result + this.value.hashCode();
	}
}