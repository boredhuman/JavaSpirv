package spirv.instructions.constantcreation;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSpecConstant implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public int[] value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.value = new int[length - 2];
		for (int i = 0; i < this.value.length; i++) {
			this.value[i] = data[offset + 2 + i];
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.value == null ? 0 : this.value.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		if (this.value != null) {
			writer.write(this.value);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SPEC_CONSTANT;
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
		if (!(o instanceof OpSpecConstant)) {
			return false;
		}
		OpSpecConstant other = (OpSpecConstant) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.value, other.value);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + Arrays.hashCode(this.value);
	}
}