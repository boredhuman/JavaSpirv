package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSetUserEventStatus implements DeviceSideEnqueueInstruction {
	public Instruction event;
	public Instruction status;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.event = instructions[data[offset]];
		this.status = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.event);
		writer.write(this.status);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SET_USER_EVENT_STATUS;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "DeviceEnqueue" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSetUserEventStatus)) {
			return false;
		}
		OpSetUserEventStatus other = (OpSetUserEventStatus) o;
		if (!this.event.equals(other.event)) {
			return false;
		}
		return this.status.equals(other.status);
	}

	@Override
	public int hashCode() {
		int result = this.event.hashCode();
		return 31 * result + this.status.hashCode();
	}
}