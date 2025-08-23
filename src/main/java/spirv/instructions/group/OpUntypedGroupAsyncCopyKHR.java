package spirv.instructions.group;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpUntypedGroupAsyncCopyKHR implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction execution;
	public Instruction destination;
	public Instruction source;
	public Instruction elementNumBytes;
	public Instruction numElements;
	public Instruction stride;
	public Instruction event;
	@BitMask(MemoryAccess.class)
	public int destinationMemoryOperands;
	public Object[] destinationMemoryOperandsArg;
	@BitMask(MemoryAccess.class)
	public int sourceMemoryOperands;
	public Object[] sourceMemoryOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.execution = instructions[data[offset + 2]];
		this.destination = instructions[data[offset + 3]];
		this.source = instructions[data[offset + 4]];
		this.elementNumBytes = instructions[data[offset + 5]];
		this.numElements = instructions[data[offset + 6]];
		this.stride = instructions[data[offset + 7]];
		this.event = instructions[data[offset + 8]];
		if (length - 9 <= 0) {
			return;
		}
		this.destinationMemoryOperands = data[offset + 9];
		this.destinationMemoryOperandsArg = MemoryAccess.loadArg(this.destinationMemoryOperands, data, offset + 10, instructions);
		int dynamicOffset = MemoryAccess.getArgumentCount(this.destinationMemoryOperands) + 10;
		if (length - dynamicOffset <= 0) {
			return;
		}
		this.sourceMemoryOperands = data[offset + dynamicOffset];
		this.sourceMemoryOperandsArg = MemoryAccess.loadArg(this.sourceMemoryOperands, data, offset + dynamicOffset, instructions);
	}

	@Override
	public int size() {
		int size = 9;
		size += this.destinationMemoryOperands == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.destinationMemoryOperands);
		size += this.sourceMemoryOperands == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.sourceMemoryOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.execution);
		writer.write(this.destination);
		writer.write(this.source);
		writer.write(this.elementNumBytes);
		writer.write(this.numElements);
		writer.write(this.stride);
		writer.write(this.event);
		if (this.destinationMemoryOperands > 0) {
			writer.write(this.destinationMemoryOperands);
			writer.write(this.destinationMemoryOperandsArg);
		}
		if (this.sourceMemoryOperands > 0) {
			writer.write(this.sourceMemoryOperands);
			writer.write(this.sourceMemoryOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_UNTYPED_GROUP_ASYNC_COPY_KHR;
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
		 return new String[] { "UntypedPointersKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpUntypedGroupAsyncCopyKHR)) {
			return false;
		}
		OpUntypedGroupAsyncCopyKHR other = (OpUntypedGroupAsyncCopyKHR) o;
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
		if (!this.elementNumBytes.equals(other.elementNumBytes)) {
			return false;
		}
		if (!this.numElements.equals(other.numElements)) {
			return false;
		}
		if (!this.stride.equals(other.stride)) {
			return false;
		}
		if (!this.event.equals(other.event)) {
			return false;
		}
		if (!Objects.equals(this.destinationMemoryOperands, other.destinationMemoryOperands)) {
			return false;
		}
		if (!Arrays.equals(this.destinationMemoryOperandsArg, other.destinationMemoryOperandsArg)) {
			return false;
		}
		if (!Objects.equals(this.sourceMemoryOperands, other.sourceMemoryOperands)) {
			return false;
		}
		return Arrays.equals(this.sourceMemoryOperandsArg, other.sourceMemoryOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.destination.hashCode();
		result += 31 * result + this.source.hashCode();
		result += 31 * result + this.elementNumBytes.hashCode();
		result += 31 * result + this.numElements.hashCode();
		result += 31 * result + this.stride.hashCode();
		result += 31 * result + this.event.hashCode();
		result += 31 * result + Objects.hashCode(this.destinationMemoryOperands);
		result += 31 * result + Arrays.hashCode(this.destinationMemoryOperandsArg);
		result += 31 * result + Objects.hashCode(this.sourceMemoryOperands);
		return 31 * result + Arrays.hashCode(this.sourceMemoryOperandsArg);
	}
}