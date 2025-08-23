package spirv.instructions.memory;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpUntypedArrayLengthKHR implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction structure;
	public Instruction pointer;
	public int arrayMember;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.structure = instructions[data[offset + 2]];
		this.pointer = instructions[data[offset + 3]];
		this.arrayMember = data[offset + 4];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.structure);
		writer.write(this.pointer);
		writer.write(this.arrayMember);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_UNTYPED_ARRAY_LENGTH_KHR;
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
		if (!(o instanceof OpUntypedArrayLengthKHR)) {
			return false;
		}
		OpUntypedArrayLengthKHR other = (OpUntypedArrayLengthKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.structure.equals(other.structure)) {
			return false;
		}
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		return this.arrayMember != other.arrayMember;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.structure.hashCode();
		result += 31 * result + this.pointer.hashCode();
		return 31 * result + this.arrayMember;
	}
}