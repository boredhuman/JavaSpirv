package spirv.instructions.pipe;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCreatePipeFromPipeStorage implements PipeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pipeStorage;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pipeStorage = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pipeStorage);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CREATE_PIPE_FROM_PIPE_STORAGE;
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
		if (!(o instanceof OpCreatePipeFromPipeStorage)) {
			return false;
		}
		OpCreatePipeFromPipeStorage other = (OpCreatePipeFromPipeStorage) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.pipeStorage.equals(other.pipeStorage);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + this.pipeStorage.hashCode();
	}
}