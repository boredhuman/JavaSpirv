package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpArbitraryFloatGTINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction a;
	public int ma;
	public Instruction b;
	public int mb;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.a = instructions[data[offset + 2]];
		this.ma = data[offset + 3];
		this.b = instructions[data[offset + 4]];
		this.mb = data[offset + 5];
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
		writer.write(this.ma);
		writer.write(this.b);
		writer.write(this.mb);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ARBITRARY_FLOAT_GTINTEL;
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
		 return new String[] { "ArbitraryPrecisionFloatingPointINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpArbitraryFloatGTINTEL)) {
			return false;
		}
		OpArbitraryFloatGTINTEL other = (OpArbitraryFloatGTINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.a.equals(other.a)) {
			return false;
		}
		if (this.ma != other.ma) {
			return false;
		}
		if (!this.b.equals(other.b)) {
			return false;
		}
		return this.mb != other.mb;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.ma;
		result += 31 * result + this.b.hashCode();
		return 31 * result + this.mb;
	}
}