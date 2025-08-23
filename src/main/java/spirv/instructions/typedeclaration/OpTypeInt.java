package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeInt implements TypeDeclarationInstruction, Result {
	public int idResult;
	public int width;
	public int signedness;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.width = data[offset + 1];
		this.signedness = data[offset + 2];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.width);
		writer.write(this.signedness);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_INT;
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
		if (!(o instanceof OpTypeInt)) {
			return false;
		}
		OpTypeInt other = (OpTypeInt) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.width != other.width) {
			return false;
		}
		return this.signedness != other.signedness;
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.width;
		return 31 * result + this.signedness;
	}
}