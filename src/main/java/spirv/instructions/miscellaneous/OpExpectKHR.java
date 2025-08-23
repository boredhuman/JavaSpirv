package spirv.instructions.miscellaneous;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpExpectKHR implements MiscellaneousInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction value;
	public Instruction expectedValue;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.value = instructions[data[offset + 2]];
		this.expectedValue = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.value);
		writer.write(this.expectedValue);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXPECT_KHR;
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
		 return new String[] { "ExpectAssumeKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_expect_assume" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExpectKHR)) {
			return false;
		}
		OpExpectKHR other = (OpExpectKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.value.equals(other.value)) {
			return false;
		}
		return this.expectedValue.equals(other.expectedValue);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.value.hashCode();
		return 31 * result + this.expectedValue.hashCode();
	}
}