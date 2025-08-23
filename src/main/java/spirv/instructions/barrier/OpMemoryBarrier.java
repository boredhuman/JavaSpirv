package spirv.instructions.barrier;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMemoryBarrier implements BarrierInstruction {
	public Instruction memory;
	public Instruction semantics;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.memory = instructions[data[offset]];
		this.semantics = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.memory);
		writer.write(this.semantics);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMORY_BARRIER;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemoryBarrier)) {
			return false;
		}
		OpMemoryBarrier other = (OpMemoryBarrier) o;
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		return this.semantics.equals(other.semantics);
	}

	@Override
	public int hashCode() {
		int result = this.memory.hashCode();
		return 31 * result + this.semantics.hashCode();
	}
}