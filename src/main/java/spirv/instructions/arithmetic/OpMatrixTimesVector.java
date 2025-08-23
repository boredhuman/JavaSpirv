package spirv.instructions.arithmetic;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpMatrixTimesVector implements ArithmeticInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction matrix;
	public Instruction vector;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.matrix = instructions[data[offset + 2]];
		this.vector = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.matrix);
		writer.write(this.vector);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MATRIX_TIMES_VECTOR;
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
		 return new String[] { "Matrix" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMatrixTimesVector)) {
			return false;
		}
		OpMatrixTimesVector other = (OpMatrixTimesVector) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.matrix.equals(other.matrix)) {
			return false;
		}
		return this.vector.equals(other.vector);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.matrix.hashCode();
		return 31 * result + this.vector.hashCode();
	}
}