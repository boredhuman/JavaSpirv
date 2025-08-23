package spirv.instructions.group;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGroupNonUniformRotateKHR implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction execution;
	public Instruction value;
	public Instruction delta;
	public Instruction clusterSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.execution = instructions[data[offset + 2]];
		this.value = instructions[data[offset + 3]];
		this.delta = instructions[data[offset + 4]];
		if (length - 5 <= 0) {
			return;
		}
		this.clusterSize = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		int size = 5;
		size += this.clusterSize == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.execution);
		writer.write(this.value);
		writer.write(this.delta);
		if (this.clusterSize != null) {
			writer.write(this.clusterSize);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_NON_UNIFORM_ROTATE_KHR;
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
		 return new String[] { "GroupNonUniformRotateKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupNonUniformRotateKHR)) {
			return false;
		}
		OpGroupNonUniformRotateKHR other = (OpGroupNonUniformRotateKHR) o;
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
		if (!this.delta.equals(other.delta)) {
			return false;
		}
		return Objects.equals(this.clusterSize, other.clusterSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.value.hashCode();
		result += 31 * result + this.delta.hashCode();
		return 31 * result + Objects.hashCode(this.clusterSize);
	}
}