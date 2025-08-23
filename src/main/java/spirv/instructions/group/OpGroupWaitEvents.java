package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpGroupWaitEvents implements GroupInstruction {
	public Instruction execution;
	public Instruction numEvents;
	public Instruction eventsList;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.execution = instructions[data[offset]];
		this.numEvents = instructions[data[offset + 1]];
		this.eventsList = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.execution);
		writer.write(this.numEvents);
		writer.write(this.eventsList);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_WAIT_EVENTS;
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
		if (!(o instanceof OpGroupWaitEvents)) {
			return false;
		}
		OpGroupWaitEvents other = (OpGroupWaitEvents) o;
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (!this.numEvents.equals(other.numEvents)) {
			return false;
		}
		return this.eventsList.equals(other.eventsList);
	}

	@Override
	public int hashCode() {
		int result = this.execution.hashCode();
		result += 31 * result + this.numEvents.hashCode();
		return 31 * result + this.eventsList.hashCode();
	}
}