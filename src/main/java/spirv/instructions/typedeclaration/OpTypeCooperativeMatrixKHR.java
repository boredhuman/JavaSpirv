package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeCooperativeMatrixKHR implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction componentType;
	public Instruction scope;
	public Instruction rows;
	public Instruction columns;
	public Instruction use;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.componentType = instructions[data[offset + 1]];
		this.scope = instructions[data[offset + 2]];
		this.rows = instructions[data[offset + 3]];
		this.columns = instructions[data[offset + 4]];
		this.use = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.componentType);
		writer.write(this.scope);
		writer.write(this.rows);
		writer.write(this.columns);
		writer.write(this.use);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_COOPERATIVE_MATRIX_KHR;
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
		if (!(o instanceof OpTypeCooperativeMatrixKHR)) {
			return false;
		}
		OpTypeCooperativeMatrixKHR other = (OpTypeCooperativeMatrixKHR) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.componentType.equals(other.componentType)) {
			return false;
		}
		if (!this.scope.equals(other.scope)) {
			return false;
		}
		if (!this.rows.equals(other.rows)) {
			return false;
		}
		if (!this.columns.equals(other.columns)) {
			return false;
		}
		return this.use.equals(other.use);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.componentType.hashCode();
		result += 31 * result + this.scope.hashCode();
		result += 31 * result + this.rows.hashCode();
		result += 31 * result + this.columns.hashCode();
		return 31 * result + this.use.hashCode();
	}
}