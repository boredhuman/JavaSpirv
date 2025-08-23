package spirv.instructions.annotation;

import spirv.enumerants.PairIdRefLiteralInteger;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpGroupMemberDecorate implements AnnotationInstruction {
	public Instruction decorationGroup;
	public PairIdRefLiteralInteger[] targets;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.decorationGroup = instructions[data[offset]];
		this.targets = new PairIdRefLiteralInteger[(length - 1) / 2];
		for (int i = 0; i < this.targets.length; i++) {
			this.targets[i] = new PairIdRefLiteralInteger(instructions[data[offset + 1 + i * 2]], data[offset + 1 + i * 2 + 1]);
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += this.targets == null ? 0 : this.targets.length * 2;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.decorationGroup);
		if (this.targets != null) {
			for (int i = 0; i < this.targets.length; i++) {
				this.targets[i].write(writer);
			}
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GROUP_MEMBER_DECORATE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGroupMemberDecorate)) {
			return false;
		}
		OpGroupMemberDecorate other = (OpGroupMemberDecorate) o;
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