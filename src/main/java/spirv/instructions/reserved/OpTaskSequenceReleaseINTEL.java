package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpTaskSequenceReleaseINTEL implements ReservedInstruction {
	public Instruction sequence;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.sequence = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.sequence);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TASK_SEQUENCE_RELEASE_INTEL;
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
		if (!(o instanceof OpTaskSequenceReleaseINTEL)) {
			return false;
		}
		OpTaskSequenceReleaseINTEL other = (OpTaskSequenceReleaseINTEL) o;
		return this.sequence.equals(other.sequence);
	}

	@Override
	public int hashCode() {
		return this.sequence.hashCode();
	}
}