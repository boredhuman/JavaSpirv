package spirv.instructions.atomic;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpAtomicIAdd implements AtomicInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pointer;
	public Instruction memory;
	public Instruction semantics;
	public Instruction value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pointer = instructions[data[offset + 2]];
		this.memory = instructions[data[offset + 3]];
		this.semantics = instructions[data[offset + 4]];
		this.value = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pointer);
		writer.write(this.memory);
		writer.write(this.semantics);
		writer.write(this.value);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ATOMIC_I_ADD;
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
		if (!(o instanceof OpAtomicIAdd)) {
			return false;
		}
		OpAtomicIAdd other = (OpAtomicIAdd) o;
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
		if (!this.semantics.equals(other.semantics)) {
			return false;
		}
		return this.value.equals(other.value);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pointer.hashCode();
		result += 31 * result + this.memory.hashCode();
		result += 31 * result + this.semantics.hashCode();
		return 31 * result + this.value.hashCode();
	}
}