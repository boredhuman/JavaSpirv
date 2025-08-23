package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpVariable implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public StorageClass storageClass;
	public Instruction initializer;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.storageClass = StorageClass.get(data[offset + 2]);
		if (length - 3 <= 0) {
			return;
		}
		this.initializer = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		int size = 3;
		size += this.initializer == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.storageClass);
		if (this.initializer != null) {
			writer.write(this.initializer);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_VARIABLE;
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
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpVariable)) {
			return false;
		}
		OpVariable other = (OpVariable) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.storageClass != other.storageClass) {
			return false;
		}
		return Objects.equals(this.initializer, other.initializer);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.storageClass.hashCode();
		return 31 * result + Objects.hashCode(this.initializer);
	}
}