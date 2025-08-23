package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGroupAsyncCopy implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction execution;
	public Instruction destination;
	public Instruction source;
	public Instruction numElements;
	public Instruction stride;
	public Instruction event;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.execution = instructions[data[offset + 2]];
		this.destination = instructions[data[offset + 3]];
		this.source = instructions[data[offset + 4]];
		this.numElements = instructions[data[offset + 5]];
		this.stride = instructions[data[offset + 6]];
		this.event = instructions[data[offset + 7]];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.execution);
		writer.write(this.destination);
		writer.write(this.source);
		writer.write(this.numElements);
		writer.write(this.stride);
		writer.write(this.event);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_ASYNC_COPY;
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
		 return new String[] { "Kernel" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupAsyncCopy)) {
			return false;
		}
		OpGroupAsyncCopy other = (OpGroupAsyncCopy) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (!this.destination.equals(other.destination)) {
			return false;
		}
		if (!this.source.equals(other.source)) {
			return false;
		}
		if (!this.numElements.equals(other.numElements)) {
			return false;
		}
		if (!this.stride.equals(other.stride)) {
			return false;
		}
		return this.event.equals(other.event);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.destination.hashCode();
		result += 31 * result + this.source.hashCode();
		result += 31 * result + this.numElements.hashCode();
		result += 31 * result + this.stride.hashCode();
		return 31 * result + this.event.hashCode();
	}
}