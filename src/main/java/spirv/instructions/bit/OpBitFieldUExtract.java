package spirv.instructions.bit;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpBitFieldUExtract implements BitInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction base;
	public Instruction offset;
	public Instruction count;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.base = instructions[data[offset + 2]];
		this.offset = instructions[data[offset + 3]];
		this.count = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.base);
		writer.write(this.offset);
		writer.write(this.count);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_BIT_FIELD_U_EXTRACT;
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
		 return new String[] { "Shader", "BitInstructions" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpBitFieldUExtract)) {
			return false;
		}
		OpBitFieldUExtract other = (OpBitFieldUExtract) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.base.equals(other.base)) {
			return false;
		}
		if (!this.offset.equals(other.offset)) {
			return false;
		}
		return this.count.equals(other.count);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.base.hashCode();
		result += 31 * result + this.offset.hashCode();
		return 31 * result + this.count.hashCode();
	}
}