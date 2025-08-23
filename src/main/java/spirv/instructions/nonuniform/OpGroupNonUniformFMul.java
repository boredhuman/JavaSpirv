package spirv.instructions.nonuniform;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.GroupOperation;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGroupNonUniformFMul implements NonUniformInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction execution;
	public GroupOperation operation;
	public Instruction value;
	public Instruction clusterSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.execution = instructions[data[offset + 2]];
		this.operation = GroupOperation.get(data[offset + 3]);
		this.value = instructions[data[offset + 4]];
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
		writer.write(this.operation);
		writer.write(this.value);
		if (this.clusterSize != null) {
			writer.write(this.clusterSize);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_NON_UNIFORM_F_MUL;
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
		 return new String[] { "GroupNonUniformArithmetic", "GroupNonUniformClustered", "GroupNonUniformPartitionedNV" };
	}

	@Override
	public String version() {
		return "1.3";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupNonUniformFMul)) {
			return false;
		}
		OpGroupNonUniformFMul other = (OpGroupNonUniformFMul) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (this.operation != other.operation) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		return Objects.equals(this.clusterSize, other.clusterSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.operation.hashCode();
		result += 31 * result + this.value.hashCode();
		return 31 * result + Objects.hashCode(this.clusterSize);
	}
}