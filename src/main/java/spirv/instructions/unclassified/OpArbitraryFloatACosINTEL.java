package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpArbitraryFloatACosINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction a;
	public int m1;
	public int mout;
	public int enableSubnormals;
	public int roundingMode;
	public int roundingAccuracy;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.a = instructions[data[offset + 2]];
		this.m1 = data[offset + 3];
		this.mout = data[offset + 4];
		this.enableSubnormals = data[offset + 5];
		this.roundingMode = data[offset + 6];
		this.roundingAccuracy = data[offset + 7];
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
		writer.write(this.m1);
		writer.write(this.mout);
		writer.write(this.enableSubnormals);
		writer.write(this.roundingMode);
		writer.write(this.roundingAccuracy);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ARBITRARY_FLOAT_A_COS_INTEL;
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
		if (!(o instanceof OpArbitraryFloatACosINTEL)) {
			return false;
		}
		OpArbitraryFloatACosINTEL other = (OpArbitraryFloatACosINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.a.equals(other.a)) {
			return false;
		}
		if (this.m1 != other.m1) {
			return false;
		}
		if (this.mout != other.mout) {
			return false;
		}
		if (this.enableSubnormals != other.enableSubnormals) {
			return false;
		}
		if (this.roundingMode != other.roundingMode) {
			return false;
		}
		return this.roundingAccuracy != other.roundingAccuracy;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.m1;
		result += 31 * result + this.mout;
		result += 31 * result + this.enableSubnormals;
		result += 31 * result + this.roundingMode;
		return 31 * result + this.roundingAccuracy;
	}
}