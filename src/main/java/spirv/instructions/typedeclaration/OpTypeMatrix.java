package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeMatrix implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction columnType;
	public int columnCount;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.columnType = instructions[data[offset + 1]];
		this.columnCount = data[offset + 2];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.columnType);
		writer.write(this.columnCount);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_MATRIX;
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
		if (!(o instanceof OpTypeMatrix)) {
			return false;
		}
		OpTypeMatrix other = (OpTypeMatrix) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.columnType.equals(other.columnType)) {
			return false;
		}
		return this.columnCount != other.columnCount;
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.columnType.hashCode();
		return 31 * result + this.columnCount;
	}
}