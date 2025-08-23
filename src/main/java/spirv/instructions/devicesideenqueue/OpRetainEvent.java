package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpRetainEvent implements DeviceSideEnqueueInstruction {
	public Instruction event;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.event = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.event);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RETAIN_EVENT;
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
		if (!(o instanceof OpRetainEvent)) {
			return false;
		}
		OpRetainEvent other = (OpRetainEvent) o;
		return this.event.equals(other.event);
	}

	@Override
	public int hashCode() {
		return this.event.hashCode();
	}
}