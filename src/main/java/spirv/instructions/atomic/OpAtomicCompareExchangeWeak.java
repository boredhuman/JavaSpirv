package spirv.instructions.atomic;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpAtomicCompareExchangeWeak implements AtomicInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pointer;
	public Instruction memory;
	public Instruction equal;
	public Instruction unequal;
	public Instruction value;
	public Instruction comparator;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pointer = instructions[data[offset + 2]];
		this.memory = instructions[data[offset + 3]];
		this.equal = instructions[data[offset + 4]];
		this.unequal = instructions[data[offset + 5]];
		this.value = instructions[data[offset + 6]];
		this.comparator = instructions[data[offset + 7]];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pointer);
		writer.write(this.memory);
		writer.write(this.equal);
		writer.write(this.unequal);
		writer.write(this.value);
		writer.write(this.comparator);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ATOMIC_COMPARE_EXCHANGE_WEAK;
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
		 return new String[] { "Kernel" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAtomicCompareExchangeWeak)) {
			return false;
		}
		OpAtomicCompareExchangeWeak other = (OpAtomicCompareExchangeWeak) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.memory.equals(other.memory)) {
			return false;
		}
		if (!this.equal.equals(other.equal)) {
			return false;
		}
		if (!this.unequal.equals(other.unequal)) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		return this.comparator.equals(other.comparator);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pointer.hashCode();
		result += 31 * result + this.memory.hashCode();
		result += 31 * result + this.equal.hashCode();
		result += 31 * result + this.unequal.hashCode();
		result += 31 * result + this.value.hashCode();
		return 31 * result + this.comparator.hashCode();
	}
}