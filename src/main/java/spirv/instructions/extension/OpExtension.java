package spirv.instructions.extension;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpExtension implements ExtensionInstruction {
	public String name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.name = InstructionUtil.readString(data, offset).getString();
	}

	@Override
	public int size() {
		int size = 0;
		size += InstructionUtil.wordCount(this.name);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.name);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXTENSION;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExtension)) {
			return false;
		}
		OpExtension other = (OpExtension) o;
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}