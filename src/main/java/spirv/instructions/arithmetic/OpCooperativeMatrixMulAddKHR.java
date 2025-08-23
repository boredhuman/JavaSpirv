package spirv.instructions.arithmetic;

import java.util.Objects;
import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.CooperativeMatrixOperands;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeMatrixMulAddKHR implements ArithmeticInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction a;
	public Instruction b;
	public Instruction c;
	@BitMask(CooperativeMatrixOperands.class)
	public int cooperativeMatrixOperands;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.a = instructions[data[offset + 2]];
		this.b = instructions[data[offset + 3]];
		this.c = instructions[data[offset + 4]];
		if (length - 5 <= 0) {
			return;
		}
		this.cooperativeMatrixOperands = data[offset + 5];
	}

	@Override
	public int size() {
		int size = 5;
		size += this.cooperativeMatrixOperands == 0 ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.a);
		writer.write(this.b);
		writer.write(this.c);
		if (this.cooperativeMatrixOperands > 0) {
			writer.write(this.cooperativeMatrixOperands);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_MUL_ADD_KHR;
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
		 return new String[] { "CooperativeMatrixKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixMulAddKHR)) {
			return false;
		}
		OpCooperativeMatrixMulAddKHR other = (OpCooperativeMatrixMulAddKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.a.equals(other.a)) {
			return false;
		}
		if (!this.b.equals(other.b)) {
			return false;
		}
		if (!this.c.equals(other.c)) {
			return false;
		}
		return Objects.equals(this.cooperativeMatrixOperands, other.cooperativeMatrixOperands);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.b.hashCode();
		result += 31 * result + this.c.hashCode();
		return 31 * result + Objects.hashCode(this.cooperativeMatrixOperands);
	}
}