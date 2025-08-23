package spirv.instructions.controlflow;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpBranch implements ControlFlowInstruction {
	public Instruction targetLabel;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.targetLabel = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.targetLabel);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_BRANCH;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpBranch)) {
			return false;
		}
		OpBranch other = (OpBranch) o;
		return this.targetLabel.equals(other.targetLabel);
	}

	@Override
	public int hashCode() {
		return this.targetLabel.hashCode();
	}
}