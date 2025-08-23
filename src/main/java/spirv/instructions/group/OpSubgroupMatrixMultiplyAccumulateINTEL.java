package spirv.instructions.group;

import java.util.Objects;
import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MatrixMultiplyAccumulateOperands;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupMatrixMultiplyAccumulateINTEL implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction kDim;
	public Instruction matrixA;
	public Instruction matrixB;
	public Instruction matrixC;
	@BitMask(MatrixMultiplyAccumulateOperands.class)
	public int matrixMultiplyAccumulateOperands;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.kDim = instructions[data[offset + 2]];
		this.matrixA = instructions[data[offset + 3]];
		this.matrixB = instructions[data[offset + 4]];
		this.matrixC = instructions[data[offset + 5]];
		if (length - 6 <= 0) {
			return;
		}
		this.matrixMultiplyAccumulateOperands = data[offset + 6];
	}

	@Override
	public int size() {
		int size = 6;
		size += this.matrixMultiplyAccumulateOperands == 0 ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.kDim);
		writer.write(this.matrixA);
		writer.write(this.matrixB);
		writer.write(this.matrixC);
		if (this.matrixMultiplyAccumulateOperands > 0) {
			writer.write(this.matrixMultiplyAccumulateOperands);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_MATRIX_MULTIPLY_ACCUMULATE_INTEL;
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
		 return new String[] { "SubgroupMatrixMultiplyAccumulateINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupMatrixMultiplyAccumulateINTEL)) {
			return false;
		}
		OpSubgroupMatrixMultiplyAccumulateINTEL other = (OpSubgroupMatrixMultiplyAccumulateINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.kDim.equals(other.kDim)) {
			return false;
		}
		if (!this.matrixA.equals(other.matrixA)) {
			return false;
		}
		if (!this.matrixB.equals(other.matrixB)) {
			return false;
		}
		if (!this.matrixC.equals(other.matrixC)) {
			return false;
		}
		return Objects.equals(this.matrixMultiplyAccumulateOperands, other.matrixMultiplyAccumulateOperands);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.kDim.hashCode();
		result += 31 * result + this.matrixA.hashCode();
		result += 31 * result + this.matrixB.hashCode();
		result += 31 * result + this.matrixC.hashCode();
		return 31 * result + Objects.hashCode(this.matrixMultiplyAccumulateOperands);
	}
}