package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpFixedRsqrtINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction input;
	public int s;
	public int i;
	public int rI;
	public int q;
	public int o;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.input = instructions[data[offset + 2]];
		this.s = data[offset + 3];
		this.i = data[offset + 4];
		this.rI = data[offset + 5];
		this.q = data[offset + 6];
		this.o = data[offset + 7];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.input);
		writer.write(this.s);
		writer.write(this.i);
		writer.write(this.rI);
		writer.write(this.q);
		writer.write(this.o);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_FIXED_RSQRT_INTEL;
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
		 return new String[] { "ArbitraryPrecisionFixedPointINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpFixedRsqrtINTEL)) {
			return false;
		}
		OpFixedRsqrtINTEL other = (OpFixedRsqrtINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.input.equals(other.input)) {
			return false;
		}
		if (this.s != other.s) {
			return false;
		}
		if (this.i != other.i) {
			return false;
		}
		if (this.rI != other.rI) {
			return false;
		}
		if (this.q != other.q) {
			return false;
		}
		return this.o != other.o;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.input.hashCode();
		result += 31 * result + this.s;
		result += 31 * result + this.i;
		result += 31 * result + this.rI;
		result += 31 * result + this.q;
		return 31 * result + this.o;
	}
}