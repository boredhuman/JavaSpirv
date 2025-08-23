package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpUntypedVariableKHR implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public StorageClass storageClass;
	public Instruction dataType;
	public Instruction initializer;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.storageClass = StorageClass.get(data[offset + 2]);
		if (length - 3 <= 0) {
			return;
		}
		this.dataType = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.initializer = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		int size = 3;
		size += this.dataType == null ? 0 : 1;
		size += this.initializer == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.storageClass);
		if (this.dataType != null) {
			writer.write(this.dataType);
		}
		if (this.initializer != null) {
			writer.write(this.initializer);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_UNTYPED_VARIABLE_KHR;
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
		if (!(o instanceof OpUntypedVariableKHR)) {
			return false;
		}
		OpUntypedVariableKHR other = (OpUntypedVariableKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.storageClass != other.storageClass) {
			return false;
		}
		if (!Objects.equals(this.dataType, other.dataType)) {
			return false;
		}
		return Objects.equals(this.initializer, other.initializer);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.storageClass.hashCode();
		result += 31 * result + Objects.hashCode(this.dataType);
		return 31 * result + Objects.hashCode(this.initializer);
	}
}