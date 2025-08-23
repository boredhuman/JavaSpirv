package spirv.instructions.unclassified;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpFunctionPointerCallINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction[] operand1;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.operand1 = new Instruction[length - 2];
		for (int i = 0; i < this.operand1.length; i++) {
			this.operand1[i] = instructions[data[offset + 2 + i]];
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.operand1 == null ? 0 : this.operand1.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		if (this.operand1 != null) {
			writer.write(this.operand1);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_FUNCTION_POINTER_CALL_INTEL;
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
		 return new String[] { "FunctionPointersINTEL" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_INTEL_function_pointers" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpFunctionPointerCallINTEL)) {
			return false;
		}
		OpFunctionPointerCallINTEL other = (OpFunctionPointerCallINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.operand1, other.operand1);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + Arrays.hashCode(this.operand1);
	}
}