package spirv.instructions.pipe;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpConstantPipeStorage implements PipeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public int packetSize;
	public int packetAlignment;
	public int capacity;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.packetSize = data[offset + 2];
		this.packetAlignment = data[offset + 3];
		this.capacity = data[offset + 4];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.packetSize);
		writer.write(this.packetAlignment);
		writer.write(this.capacity);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONSTANT_PIPE_STORAGE;
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
		 return new String[] { "PipeStorage" };
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConstantPipeStorage)) {
			return false;
		}
		OpConstantPipeStorage other = (OpConstantPipeStorage) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.packetSize != other.packetSize) {
			return false;
		}
		if (this.packetAlignment != other.packetAlignment) {
			return false;
		}
		return this.capacity != other.capacity;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.packetSize;
		result += 31 * result + this.packetAlignment;
		return 31 * result + this.capacity;
	}
}