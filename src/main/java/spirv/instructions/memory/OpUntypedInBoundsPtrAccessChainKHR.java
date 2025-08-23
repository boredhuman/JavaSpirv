package spirv.instructions.memory;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpUntypedInBoundsPtrAccessChainKHR implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction baseType;
	public Instruction base;
	public Instruction element;
	public Instruction[] indexes;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.baseType = instructions[data[offset + 2]];
		this.base = instructions[data[offset + 3]];
		this.element = instructions[data[offset + 4]];
		this.indexes = new Instruction[length - 5];
		for (int i = 0; i < this.indexes.length; i++) {
			this.indexes[i] = instructions[data[offset + 5 + i]];
		}
	}

	@Override
	public int size() {
		int size = 5;
		size += this.indexes == null ? 0 : this.indexes.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.baseType);
		writer.write(this.base);
		writer.write(this.element);
		if (this.indexes != null) {
			writer.write(this.indexes);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_UNTYPED_IN_BOUNDS_PTR_ACCESS_CHAIN_KHR;
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
		if (!(o instanceof OpUntypedInBoundsPtrAccessChainKHR)) {
			return false;
		}
		OpUntypedInBoundsPtrAccessChainKHR other = (OpUntypedInBoundsPtrAccessChainKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.baseType.equals(other.baseType)) {
			return false;
		}
		if (!this.base.equals(other.base)) {
			return false;
		}
		if (!this.element.equals(other.element)) {
			return false;
		}
		return Arrays.equals(this.indexes, other.indexes);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.baseType.hashCode();
		result += 31 * result + this.base.hashCode();
		result += 31 * result + this.element.hashCode();
		return 31 * result + Arrays.hashCode(this.indexes);
	}
}