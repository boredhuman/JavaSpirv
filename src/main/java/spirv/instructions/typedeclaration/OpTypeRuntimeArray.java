package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeRuntimeArray implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction elementType;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.elementType = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.elementType);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_RUNTIME_ARRAY;
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
		 return new String[] { "Shader" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeRuntimeArray)) {
			return false;
		}
		OpTypeRuntimeArray other = (OpTypeRuntimeArray) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.elementType.equals(other.elementType);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.elementType.hashCode();
	}
}