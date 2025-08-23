package spirv.instructions.reserved;

import java.util.Objects;
import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.CooperativeMatrixOperands;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeVectorMatrixMulAddNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction input;
	public Instruction inputInterpretation;
	public Instruction matrix;
	public Instruction matrixOffset;
	public Instruction matrixInterpretation;
	public Instruction bias;
	public Instruction biasOffset;
	public Instruction biasInterpretation;
	public Instruction m;
	public Instruction k;
	public Instruction memoryLayout;
	public Instruction transpose;
	public Instruction matrixStride;
	@BitMask(CooperativeMatrixOperands.class)
	public int cooperativeMatrixOperands;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.input = instructions[data[offset + 2]];
		this.inputInterpretation = instructions[data[offset + 3]];
		this.matrix = instructions[data[offset + 4]];
		this.matrixOffset = instructions[data[offset + 5]];
		this.matrixInterpretation = instructions[data[offset + 6]];
		this.bias = instructions[data[offset + 7]];
		this.biasOffset = instructions[data[offset + 8]];
		this.biasInterpretation = instructions[data[offset + 9]];
		this.m = instructions[data[offset + 10]];
		this.k = instructions[data[offset + 11]];
		this.memoryLayout = instructions[data[offset + 12]];
		this.transpose = instructions[data[offset + 13]];
		if (length - 14 <= 0) {
			return;
		}
		this.matrixStride = instructions[data[offset + 14]];
		if (length - 15 <= 0) {
			return;
		}
		this.cooperativeMatrixOperands = data[offset + 15];
	}

	@Override
	public int size() {
		int size = 14;
		size += this.matrixStride == null ? 0 : 1;
		size += this.cooperativeMatrixOperands == 0 ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.input);
		writer.write(this.inputInterpretation);
		writer.write(this.matrix);
		writer.write(this.matrixOffset);
		writer.write(this.matrixInterpretation);
		writer.write(this.bias);
		writer.write(this.biasOffset);
		writer.write(this.biasInterpretation);
		writer.write(this.m);
		writer.write(this.k);
		writer.write(this.memoryLayout);
		writer.write(this.transpose);
		if (this.matrixStride != null) {
			writer.write(this.matrixStride);
		}
		if (this.cooperativeMatrixOperands > 0) {
			writer.write(this.cooperativeMatrixOperands);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_VECTOR_MATRIX_MUL_ADD_NV;
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
		 return new String[] { "CooperativeVectorNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeVectorMatrixMulAddNV)) {
			return false;
		}
		OpCooperativeVectorMatrixMulAddNV other = (OpCooperativeVectorMatrixMulAddNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.input.equals(other.input)) {
			return false;
		}
		if (!this.inputInterpretation.equals(other.inputInterpretation)) {
			return false;
		}
		if (!this.matrix.equals(other.matrix)) {
			return false;
		}
		if (!this.matrixOffset.equals(other.matrixOffset)) {
			return false;
		}
		if (!this.matrixInterpretation.equals(other.matrixInterpretation)) {
			return false;
		}
		if (!this.bias.equals(other.bias)) {
			return false;
		}
		if (!this.biasOffset.equals(other.biasOffset)) {
			return false;
		}
		if (!this.biasInterpretation.equals(other.biasInterpretation)) {
			return false;
		}
		if (!this.m.equals(other.m)) {
			return false;
		}
		if (!this.k.equals(other.k)) {
			return false;
		}
		if (!this.memoryLayout.equals(other.memoryLayout)) {
			return false;
		}
		if (!this.transpose.equals(other.transpose)) {
			return false;
		}
		if (!Objects.equals(this.matrixStride, other.matrixStride)) {
			return false;
		}
		return Objects.equals(this.cooperativeMatrixOperands, other.cooperativeMatrixOperands);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.input.hashCode();
		result += 31 * result + this.inputInterpretation.hashCode();
		result += 31 * result + this.matrix.hashCode();
		result += 31 * result + this.matrixOffset.hashCode();
		result += 31 * result + this.matrixInterpretation.hashCode();
		result += 31 * result + this.bias.hashCode();
		result += 31 * result + this.biasOffset.hashCode();
		result += 31 * result + this.biasInterpretation.hashCode();
		result += 31 * result + this.m.hashCode();
		result += 31 * result + this.k.hashCode();
		result += 31 * result + this.memoryLayout.hashCode();
		result += 31 * result + this.transpose.hashCode();
		result += 31 * result + Objects.hashCode(this.matrixStride);
		return 31 * result + Objects.hashCode(this.cooperativeMatrixOperands);
	}
}