package spirv.instructions.controlflow;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpBranchConditional implements ControlFlowInstruction {
	public Instruction condition;
	public Instruction trueLabel;
	public Instruction falseLabel;
	public int[] branchWeights;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.condition = instructions[data[offset]];
		this.trueLabel = instructions[data[offset + 1]];
		this.falseLabel = instructions[data[offset + 2]];
		this.branchWeights = new int[length - 3];
		for (int i = 0; i < this.branchWeights.length; i++) {
			this.branchWeights[i] = data[offset + 3 + i];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.branchWeights == null ? 0 : this.branchWeights.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.condition);
		writer.write(this.trueLabel);
		writer.write(this.falseLabel);
		if (this.branchWeights != null) {
			writer.write(this.branchWeights);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_BRANCH_CONDITIONAL;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpBranchConditional)) {
			return false;
		}
		OpBranchConditional other = (OpBranchConditional) o;
		if (!this.condition.equals(other.condition)) {
			return false;
		}
		if (!this.trueLabel.equals(other.trueLabel)) {
			return false;
		}
		if (!this.falseLabel.equals(other.falseLabel)) {
			return false;
		}
		return Arrays.equals(this.branchWeights, other.branchWeights);
	}

	@Override
	public int hashCode() {
		int result = this.condition.hashCode();
		result += 31 * result + this.trueLabel.hashCode();
		result += 31 * result + this.falseLabel.hashCode();
		return 31 * result + Arrays.hashCode(this.branchWeights);
	}
}