package spirv.instructions.debug;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpModuleProcessed implements DebugInstruction {
	public String process;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.process = InstructionUtil.readString(data, offset).getString();
	}

	@Override
	public int size() {
		int size = 0;
		size += InstructionUtil.wordCount(this.process);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.process);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MODULE_PROCESSED;
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpModuleProcessed)) {
			return false;
		}
		OpModuleProcessed other = (OpModuleProcessed) o;
		return this.process.equals(other.process);
	}

	@Override
	public int hashCode() {
		return this.process.hashCode();
	}
}