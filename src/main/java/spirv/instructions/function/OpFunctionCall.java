package spirv.instructions.function;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpFunctionCall implements FunctionInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction function;
	public Instruction[] argument0;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.function = instructions[data[offset + 2]];
		this.argument0 = new Instruction[length - 3];
		for (int i = 0; i < this.argument0.length; i++) {
			this.argument0[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.argument0 == null ? 0 : this.argument0.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.function);
		if (this.argument0 != null) {
			writer.write(this.argument0);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_FUNCTION_CALL;
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
		if (!(o instanceof OpFunctionCall)) {
			return false;
		}
		OpFunctionCall other = (OpFunctionCall) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.function.equals(other.function)) {
			return false;
		}
		return Arrays.equals(this.argument0, other.argument0);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.function.hashCode();
		return 31 * result + Arrays.hashCode(this.argument0);
	}
}