package spirv.instructions.arithmetic;

import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.enumerants.CooperativeMatrixReduce;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeMatrixReduceNV implements ArithmeticInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction matrix;
	@BitMask(CooperativeMatrixReduce.class)
	public int reduce;
	public Instruction combineFunc;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.matrix = instructions[data[offset + 2]];
		this.reduce = data[offset + 3];
		this.combineFunc = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.matrix);
		writer.write(this.reduce);
		writer.write(this.combineFunc);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_REDUCE_NV;
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
		 return new String[] { "CooperativeMatrixReductionsNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixReduceNV)) {
			return false;
		}
		OpCooperativeMatrixReduceNV other = (OpCooperativeMatrixReduceNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.matrix.equals(other.matrix)) {
			return false;
		}
		if (this.reduce != other.reduce) {
			return false;
		}
		return this.combineFunc.equals(other.combineFunc);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.matrix.hashCode();
		result += 31 * result + this.reduce;
		return 31 * result + this.combineFunc.hashCode();
	}
}