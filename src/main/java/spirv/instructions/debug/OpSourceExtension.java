package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpSourceExtension implements DebugInstruction {
	public String extension;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.extension = InstructionUtil.readString(data, offset).getString();
	}

	@Override
	public int size() {
		int size = 0;
		size += InstructionUtil.wordCount(this.extension);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.extension);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SOURCE_EXTENSION;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSourceExtension)) {
			return false;
		}
		OpSourceExtension other = (OpSourceExtension) o;
		return this.extension.equals(other.extension);
	}

	@Override
	public int hashCode() {
		return this.extension.hashCode();
	}
}