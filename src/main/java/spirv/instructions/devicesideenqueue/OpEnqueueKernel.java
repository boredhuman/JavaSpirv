package spirv.instructions.devicesideenqueue;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpEnqueueKernel implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction queue;
	public Instruction flags;
	public Instruction ndRange;
	public Instruction numEvents;
	public Instruction waitEvents;
	public Instruction retEvent;
	public Instruction invoke;
	public Instruction param;
	public Instruction paramSize;
	public Instruction paramAlign;
	public Instruction[] localSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.queue = instructions[data[offset + 2]];
		this.flags = instructions[data[offset + 3]];
		this.ndRange = instructions[data[offset + 4]];
		this.numEvents = instructions[data[offset + 5]];
		this.waitEvents = instructions[data[offset + 6]];
		this.retEvent = instructions[data[offset + 7]];
		this.invoke = instructions[data[offset + 8]];
		this.param = instructions[data[offset + 9]];
		this.paramSize = instructions[data[offset + 10]];
		this.paramAlign = instructions[data[offset + 11]];
		this.localSize = new Instruction[length - 12];
		for (int i = 0; i < this.localSize.length; i++) {
			this.localSize[i] = instructions[data[offset + 12 + i]];
		}
	}

	@Override
	public int size() {
		int size = 12;
		size += this.localSize == null ? 0 : this.localSize.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.queue);
		writer.write(this.flags);
		writer.write(this.ndRange);
		writer.write(this.numEvents);
		writer.write(this.waitEvents);
		writer.write(this.retEvent);
		writer.write(this.invoke);
		writer.write(this.param);
		writer.write(this.paramSize);
		writer.write(this.paramAlign);
		if (this.localSize != null) {
			writer.write(this.localSize);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ENQUEUE_KERNEL;
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
		if (!(o instanceof OpEnqueueKernel)) {
			return false;
		}
		OpEnqueueKernel other = (OpEnqueueKernel) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.queue.equals(other.queue)) {
			return false;
		}
		if (!this.flags.equals(other.flags)) {
			return false;
		}
		if (!this.ndRange.equals(other.ndRange)) {
			return false;
		}
		if (!this.numEvents.equals(other.numEvents)) {
			return false;
		}
		if (!this.waitEvents.equals(other.waitEvents)) {
			return false;
		}
		if (!this.retEvent.equals(other.retEvent)) {
			return false;
		}
		if (!this.invoke.equals(other.invoke)) {
			return false;
		}
		if (!this.param.equals(other.param)) {
			return false;
		}
		if (!this.paramSize.equals(other.paramSize)) {
			return false;
		}
		if (!this.paramAlign.equals(other.paramAlign)) {
			return false;
		}
		return Arrays.equals(this.localSize, other.localSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.queue.hashCode();
		result += 31 * result + this.flags.hashCode();
		result += 31 * result + this.ndRange.hashCode();
		result += 31 * result + this.numEvents.hashCode();
		result += 31 * result + this.waitEvents.hashCode();
		result += 31 * result + this.retEvent.hashCode();
		result += 31 * result + this.invoke.hashCode();
		result += 31 * result + this.param.hashCode();
		result += 31 * result + this.paramSize.hashCode();
		result += 31 * result + this.paramAlign.hashCode();
		return 31 * result + Arrays.hashCode(this.localSize);
	}
}