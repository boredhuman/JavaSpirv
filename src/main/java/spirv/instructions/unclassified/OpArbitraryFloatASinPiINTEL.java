package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpArbitraryFloatASinPiINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction a;
	public int ma;
	public int mresult;
	public int subnormal;
	public int rounding;
	public int accuracy;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.a = instructions[data[offset + 2]];
		this.ma = data[offset + 3];
		this.mresult = data[offset + 4];
		this.subnormal = data[offset + 5];
		this.rounding = data[offset + 6];
		this.accuracy = data[offset + 7];
	}

	@Override
	public int size() {
		return 8;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.a);
		writer.write(this.ma);
		writer.write(this.mresult);
		writer.write(this.subnormal);
		writer.write(this.rounding);
		writer.write(this.accuracy);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ARBITRARY_FLOAT_A_SIN_PI_INTEL;
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
		if (!(o instanceof OpArbitraryFloatASinPiINTEL)) {
			return false;
		}
		OpArbitraryFloatASinPiINTEL other = (OpArbitraryFloatASinPiINTEL) o;
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
		if (this.mresult != other.mresult) {
			return false;
		}
		if (this.subnormal != other.subnormal) {
			return false;
		}
		if (this.rounding != other.rounding) {
			return false;
		}
		return this.accuracy != other.accuracy;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.ma;
		result += 31 * result + this.mresult;
		result += 31 * result + this.subnormal;
		result += 31 * result + this.rounding;
		return 31 * result + this.accuracy;
	}
}