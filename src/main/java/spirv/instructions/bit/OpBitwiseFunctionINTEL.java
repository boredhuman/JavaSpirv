package spirv.instructions.bit;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpBitwiseFunctionINTEL implements BitInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction a;
	public Instruction b;
	public Instruction c;
	public Instruction lutIndex;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.a = instructions[data[offset + 2]];
		this.b = instructions[data[offset + 3]];
		this.c = instructions[data[offset + 4]];
		this.lutIndex = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.a);
		writer.write(this.b);
		writer.write(this.c);
		writer.write(this.lutIndex);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_BITWISE_FUNCTION_INTEL;
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
		 return new String[] { "TernaryBitwiseFunctionINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpBitwiseFunctionINTEL)) {
			return false;
		}
		OpBitwiseFunctionINTEL other = (OpBitwiseFunctionINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.a.equals(other.a)) {
			return false;
		}
		if (!this.b.equals(other.b)) {
			return false;
		}
		if (!this.c.equals(other.c)) {
			return false;
		}
		return this.lutIndex.equals(other.lutIndex);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.b.hashCode();
		result += 31 * result + this.c.hashCode();
		return 31 * result + this.lutIndex.hashCode();
	}
}