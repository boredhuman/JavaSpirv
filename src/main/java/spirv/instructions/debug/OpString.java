package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.Result;

public class OpString implements DebugInstruction, Result {
	public int idResult;
	public String string;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.string = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.string);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.string);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_STRING;
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
		if (!(o instanceof OpString)) {
			return false;
		}
		OpString other = (OpString) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.string.equals(other.string);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.string.hashCode();
	}
}