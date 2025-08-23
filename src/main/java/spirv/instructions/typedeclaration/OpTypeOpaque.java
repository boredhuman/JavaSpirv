package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.Result;

public class OpTypeOpaque implements TypeDeclarationInstruction, Result {
	public int idResult;
	public String theNameOfTheOpaqueType;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.theNameOfTheOpaqueType = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.theNameOfTheOpaqueType);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.theNameOfTheOpaqueType);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_OPAQUE;
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
		 return new String[] { "Kernel" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeOpaque)) {
			return false;
		}
		OpTypeOpaque other = (OpTypeOpaque) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.theNameOfTheOpaqueType.equals(other.theNameOfTheOpaqueType);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.theNameOfTheOpaqueType.hashCode();
	}
}