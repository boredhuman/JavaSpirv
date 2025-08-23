package spirv.instructions.barrier;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpControlBarrier implements BarrierInstruction {
	public Instruction execution;
	public Instruction memory;
	public Instruction semantics;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.execution = instructions[data[offset]];
		this.memory = instructions[data[offset + 1]];
		this.semantics = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.execution);
		writer.write(this.memory);
		writer.write(this.semantics);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONTROL_BARRIER;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpControlBarrier)) {
			return false;
		}
		OpControlBarrier other = (OpControlBarrier) o;
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		return this.semantics.equals(other.semantics);
	}

	@Override
	public int hashCode() {
		int result = this.execution.hashCode();
		result += 31 * result + this.memory.hashCode();
		return 31 * result + this.semantics.hashCode();
	}
}