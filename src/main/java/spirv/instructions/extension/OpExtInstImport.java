package spirv.instructions.extension;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.Result;

public class OpExtInstImport implements ExtensionInstruction, Result {
	public int idResult;
	public String name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.name = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.name);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.name);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXT_INST_IMPORT;
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
		if (!(o instanceof OpExtInstImport)) {
			return false;
		}
		OpExtInstImport other = (OpExtInstImport) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.name.hashCode();
	}
}