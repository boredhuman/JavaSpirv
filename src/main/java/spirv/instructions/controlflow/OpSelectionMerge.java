package spirv.instructions.controlflow;

import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.enumerants.SelectionControl;
import spirv.instructions.Instruction;

public class OpSelectionMerge implements ControlFlowInstruction {
	public Instruction mergeBlock;
	@BitMask(SelectionControl.class)
	public int selectionControl;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.mergeBlock = instructions[data[offset]];
		this.selectionControl = data[offset + 1];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.mergeBlock);
		writer.write(this.selectionControl);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SELECTION_MERGE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSelectionMerge)) {
			return false;
		}
		OpSelectionMerge other = (OpSelectionMerge) o;
		if (!this.mergeBlock.equals(other.mergeBlock)) {
			return false;
		}
		return this.selectionControl != other.selectionControl;
	}

	@Override
	public int hashCode() {
		int result = this.mergeBlock.hashCode();
		return 31 * result + this.selectionControl;
	}
}