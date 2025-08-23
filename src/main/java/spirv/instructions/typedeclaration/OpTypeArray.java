package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeArray implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction elementType;
	public Instruction length;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.elementType = instructions[data[offset + 1]];
		this.length = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.elementType);
		writer.write(this.length);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_ARRAY;
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
		if (!(o instanceof OpTypeArray)) {
			return false;
		}
		OpTypeArray other = (OpTypeArray) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.elementType.equals(other.elementType)) {
			return false;
		}
		return this.length.equals(other.length);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.elementType.hashCode();
		return 31 * result + this.length.hashCode();
	}
}