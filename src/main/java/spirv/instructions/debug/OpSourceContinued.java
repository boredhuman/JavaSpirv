package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpSourceContinued implements DebugInstruction {
	public String continuedSource;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.continuedSource = InstructionUtil.readString(data, offset).getString();
	}

	@Override
	public int size() {
		int size = 0;
		size += InstructionUtil.wordCount(this.continuedSource);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.continuedSource);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SOURCE_CONTINUED;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSourceContinued)) {
			return false;
		}
		OpSourceContinued other = (OpSourceContinued) o;
		return this.continuedSource.equals(other.continuedSource);
	}

	@Override
	public int hashCode() {
		return this.continuedSource.hashCode();
	}
}