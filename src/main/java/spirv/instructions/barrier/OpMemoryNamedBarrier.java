package spirv.instructions.barrier;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMemoryNamedBarrier implements BarrierInstruction {
	public Instruction namedBarrier;
	public Instruction memory;
	public Instruction semantics;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.namedBarrier = instructions[data[offset]];
		this.memory = instructions[data[offset + 1]];
		this.semantics = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.namedBarrier);
		writer.write(this.memory);
		writer.write(this.semantics);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMORY_NAMED_BARRIER;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "NamedBarrier" };
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemoryNamedBarrier)) {
			return false;
		}
		OpMemoryNamedBarrier other = (OpMemoryNamedBarrier) o;
		if (!this.namedBarrier.equals(other.namedBarrier)) {
			return false;
		}
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		return this.semantics.equals(other.semantics);
	}

	@Override
	public int hashCode() {
		int result = this.namedBarrier.hashCode();
		result += 31 * result + this.memory.hashCode();
		return 31 * result + this.semantics.hashCode();
	}
}