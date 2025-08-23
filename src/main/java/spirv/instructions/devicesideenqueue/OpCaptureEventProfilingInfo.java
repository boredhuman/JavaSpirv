package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpCaptureEventProfilingInfo implements DeviceSideEnqueueInstruction {
	public Instruction event;
	public Instruction profilingInfo;
	public Instruction value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.event = instructions[data[offset]];
		this.profilingInfo = instructions[data[offset + 1]];
		this.value = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.event);
		writer.write(this.profilingInfo);
		writer.write(this.value);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CAPTURE_EVENT_PROFILING_INFO;
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
		if (!(o instanceof OpCaptureEventProfilingInfo)) {
			return false;
		}
		OpCaptureEventProfilingInfo other = (OpCaptureEventProfilingInfo) o;
		if (!this.event.equals(other.event)) {
			return false;
		}
		if (!this.profilingInfo.equals(other.profilingInfo)) {
			return false;
		}
		return this.value.equals(other.value);
	}

	@Override
	public int hashCode() {
		int result = this.event.hashCode();
		result += 31 * result + this.profilingInfo.hashCode();
		return 31 * result + this.value.hashCode();
	}
}