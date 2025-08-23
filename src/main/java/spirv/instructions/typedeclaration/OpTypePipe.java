package spirv.instructions.typedeclaration;

import spirv.enumerants.AccessQualifier;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypePipe implements TypeDeclarationInstruction, Result {
	public int idResult;
	public AccessQualifier qualifier;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.qualifier = AccessQualifier.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.qualifier);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_PIPE;
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
		 return new String[] { "Pipes" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypePipe)) {
			return false;
		}
		OpTypePipe other = (OpTypePipe) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.qualifier != other.qualifier;
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.qualifier.hashCode();
	}
}