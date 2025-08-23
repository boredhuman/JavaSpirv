package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeCooperativeMatrixNV implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction componentType;
	public Instruction execution;
	public Instruction rows;
	public Instruction columns;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.componentType = instructions[data[offset + 1]];
		this.execution = instructions[data[offset + 2]];
		this.rows = instructions[data[offset + 3]];
		this.columns = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.componentType);
		writer.write(this.execution);
		writer.write(this.rows);
		writer.write(this.columns);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_COOPERATIVE_MATRIX_NV;
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
		 return new String[] { "CooperativeMatrixNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_cooperative_matrix" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeCooperativeMatrixNV)) {
			return false;
		}
		OpTypeCooperativeMatrixNV other = (OpTypeCooperativeMatrixNV) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.componentType.equals(other.componentType)) {
			return false;
		}
		if (!this.execution.equals(other.execution)) {
			return false;
		}
		if (!this.rows.equals(other.rows)) {
			return false;
		}
		return this.columns.equals(other.columns);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.componentType.hashCode();
		result += 31 * result + this.execution.hashCode();
		result += 31 * result + this.rows.hashCode();
		return 31 * result + this.columns.hashCode();
	}
}