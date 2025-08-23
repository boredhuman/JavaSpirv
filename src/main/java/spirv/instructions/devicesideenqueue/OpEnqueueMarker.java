package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpEnqueueMarker implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction queue;
	public Instruction numEvents;
	public Instruction waitEvents;
	public Instruction retEvent;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.queue = instructions[data[offset + 2]];
		this.numEvents = instructions[data[offset + 3]];
		this.waitEvents = instructions[data[offset + 4]];
		this.retEvent = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.queue);
		writer.write(this.numEvents);
		writer.write(this.waitEvents);
		writer.write(this.retEvent);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ENQUEUE_MARKER;
	}

	@Override
	public Instruction resultType() {
		return this.idResultType;
	}

	@Override
	public void setResultType(Instruction resultType) {
		this.idResultType = resultType;
	}

	@Override
	public int result() {
		return this.idResult;
	}

	@Override
	public void setResult(int result) {
		this.idResult = result;
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
		if (!(o instanceof OpEnqueueMarker)) {
			return false;
		}
		OpEnqueueMarker other = (OpEnqueueMarker) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.queue.equals(other.queue)) {
			return false;
		}
		if (!this.numEvents.equals(other.numEvents)) {
			return false;
		}
		if (!this.waitEvents.equals(other.waitEvents)) {
			return false;
		}
		return this.retEvent.equals(other.retEvent);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.queue.hashCode();
		result += 31 * result + this.numEvents.hashCode();
		result += 31 * result + this.waitEvents.hashCode();
		return 31 * result + this.retEvent.hashCode();
	}
}