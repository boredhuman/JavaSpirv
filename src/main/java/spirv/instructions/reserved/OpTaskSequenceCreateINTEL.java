package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTaskSequenceCreateINTEL implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction function;
	public int pipelined;
	public int useStallEnableClusters;
	public int getCapacity;
	public int asyncCapacity;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.function = instructions[data[offset + 2]];
		this.pipelined = data[offset + 3];
		this.useStallEnableClusters = data[offset + 4];
		this.getCapacity = data[offset + 5];
		this.asyncCapacity = data[offset + 6];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.function);
		writer.write(this.pipelined);
		writer.write(this.useStallEnableClusters);
		writer.write(this.getCapacity);
		writer.write(this.asyncCapacity);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TASK_SEQUENCE_CREATE_INTEL;
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
		 return new String[] { "TaskSequenceINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTaskSequenceCreateINTEL)) {
			return false;
		}
		OpTaskSequenceCreateINTEL other = (OpTaskSequenceCreateINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.function.equals(other.function)) {
			return false;
		}
		if (this.pipelined != other.pipelined) {
			return false;
		}
		if (this.useStallEnableClusters != other.useStallEnableClusters) {
			return false;
		}
		if (this.getCapacity != other.getCapacity) {
			return false;
		}
		return this.asyncCapacity != other.asyncCapacity;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.function.hashCode();
		result += 31 * result + this.pipelined;
		result += 31 * result + this.useStallEnableClusters;
		result += 31 * result + this.getCapacity;
		return 31 * result + this.asyncCapacity;
	}
}