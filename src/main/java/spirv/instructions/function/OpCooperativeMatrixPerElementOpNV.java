package spirv.instructions.function;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeMatrixPerElementOpNV implements FunctionInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction matrix;
	public Instruction func;
	public Instruction[] operands;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.matrix = instructions[data[offset + 2]];
		this.func = instructions[data[offset + 3]];
		this.operands = new Instruction[length - 4];
		for (int i = 0; i < this.operands.length; i++) {
			this.operands[i] = instructions[data[offset + 4 + i]];
		}
	}

	@Override
	public int size() {
		int size = 4;
		size += this.operands == null ? 0 : this.operands.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.matrix);
		writer.write(this.func);
		if (this.operands != null) {
			writer.write(this.operands);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_PER_ELEMENT_OP_NV;
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
		 return new String[] { "CooperativeMatrixPerElementOperationsNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixPerElementOpNV)) {
			return false;
		}
		OpCooperativeMatrixPerElementOpNV other = (OpCooperativeMatrixPerElementOpNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.matrix.equals(other.matrix)) {
			return false;
		}
		if (!this.func.equals(other.func)) {
			return false;
		}
		return Arrays.equals(this.operands, other.operands);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.matrix.hashCode();
		result += 31 * result + this.func.hashCode();
		return 31 * result + Arrays.hashCode(this.operands);
	}
}