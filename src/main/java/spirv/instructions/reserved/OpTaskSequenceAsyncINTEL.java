package spirv.instructions.reserved;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpTaskSequenceAsyncINTEL implements ReservedInstruction {
	public Instruction sequence;
	public Instruction[] arguments;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.sequence = instructions[data[offset]];
		this.arguments = new Instruction[length - 1];
		for (int i = 0; i < this.arguments.length; i++) {
			this.arguments[i] = instructions[data[offset + 1 + i]];
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += this.arguments == null ? 0 : this.arguments.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.sequence);
		if (this.arguments != null) {
			writer.write(this.arguments);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TASK_SEQUENCE_ASYNC_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "TaskSequenceINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTaskSequenceAsyncINTEL)) {
			return false;
		}
		OpTaskSequenceAsyncINTEL other = (OpTaskSequenceAsyncINTEL) o;
		if (!this.sequence.equals(other.sequence)) {
			return false;
		}
		return Arrays.equals(this.arguments, other.arguments);
	}

	@Override
	public int hashCode() {
		int result = this.sequence.hashCode();
		return 31 * result + Arrays.hashCode(this.arguments);
	}
}