package spirv.instructions.annotation;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpGroupDecorate implements AnnotationInstruction {
	public Instruction decorationGroup;
	public Instruction[] targets;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.decorationGroup = instructions[data[offset]];
		this.targets = new Instruction[length - 1];
		for (int i = 0; i < this.targets.length; i++) {
			this.targets[i] = instructions[data[offset + 1 + i]];
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += this.targets == null ? 0 : this.targets.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.decorationGroup);
		if (this.targets != null) {
			writer.write(this.targets);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_DECORATE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupDecorate)) {
			return false;
		}
		OpGroupDecorate other = (OpGroupDecorate) o;
		if (!this.decorationGroup.equals(other.decorationGroup)) {
			return false;
		}
		return Arrays.equals(this.targets, other.targets);
	}

	@Override
	public int hashCode() {
		int result = this.decorationGroup.hashCode();
		return 31 * result + Arrays.hashCode(this.targets);
	}
}