package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.Result;

public class OpConstantStringAMDX implements ReservedInstruction, Result {
	public int idResult;
	public String literalString;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.literalString = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.literalString);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.literalString);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONSTANT_STRING_AMDX;
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
		 return new String[] { "ShaderEnqueueAMDX" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConstantStringAMDX)) {
			return false;
		}
		OpConstantStringAMDX other = (OpConstantStringAMDX) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.literalString.equals(other.literalString);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.literalString.hashCode();
	}
}