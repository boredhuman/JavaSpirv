package spirv.instructions.controlflow;

import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.LoopControl;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpLoopMerge implements ControlFlowInstruction {
	public Instruction mergeBlock;
	public Instruction continueTarget;
	@BitMask(LoopControl.class)
	public int loopControl;
	public int[] loopControlArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.mergeBlock = instructions[data[offset]];
		this.continueTarget = instructions[data[offset + 1]];
		this.loopControl = data[offset + 2];
		this.loopControlArg = new int[LoopControl.getArgumentCount(this.loopControl)];
		for (int i = 0; i < this.loopControlArg.length; i++) {
			this.loopControlArg[i] = data[offset + 3 + i];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += LoopControl.getArgumentCount(this.loopControl);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.mergeBlock);
		writer.write(this.continueTarget);
		writer.write(this.loopControl);
		if (this.loopControl > 0) {
			writer.write(this.loopControlArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_LOOP_MERGE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpLoopMerge)) {
			return false;
		}
		OpLoopMerge other = (OpLoopMerge) o;
		if (!this.mergeBlock.equals(other.mergeBlock)) {
			return false;
		}
		if (!this.continueTarget.equals(other.continueTarget)) {
			return false;
		}
		if (this.loopControl != other.loopControl) {
			return false;
		}
		return Arrays.equals(this.loopControlArg, other.loopControlArg);
	}

	@Override
	public int hashCode() {
		int result = this.mergeBlock.hashCode();
		result += 31 * result + this.continueTarget.hashCode();
		result += 31 * result + this.loopControl;
		return 31 * result + Arrays.hashCode(this.loopControlArg);
	}
}