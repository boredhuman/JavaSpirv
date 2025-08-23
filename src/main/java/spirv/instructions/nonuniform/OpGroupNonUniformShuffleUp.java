package spirv.instructions.nonuniform;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGroupNonUniformShuffleUp implements NonUniformInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction execution;
	public Instruction value;
	public Instruction delta;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.execution = instructions[data[offset + 2]];
		this.value = instructions[data[offset + 3]];
		this.delta = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.execution);
		writer.write(this.value);
		writer.write(this.delta);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_NON_UNIFORM_SHUFFLE_UP;
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
		 return new String[] { "GroupNonUniformShuffleRelative" };
	}

	@Override
	public String version() {
		return "1.3";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupNonUniformShuffleUp)) {
			return false;
		}
		OpGroupNonUniformShuffleUp other = (OpGroupNonUniformShuffleUp) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		return this.delta.equals(other.delta);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.value.hashCode();
		return 31 * result + this.delta.hashCode();
	}
}