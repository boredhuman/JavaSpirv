package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpReorderThreadWithHintNV implements ReservedInstruction {
	public Instruction hint;
	public Instruction bits;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hint = instructions[data[offset]];
		this.bits = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hint);
		writer.write(this.bits);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_REORDER_THREAD_WITH_HINT_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "ShaderInvocationReorderNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpReorderThreadWithHintNV)) {
			return false;
		}
		OpReorderThreadWithHintNV other = (OpReorderThreadWithHintNV) o;
		if (!this.hint.equals(other.hint)) {
			return false;
		}
		return this.bits.equals(other.bits);
	}

	@Override
	public int hashCode() {
		int result = this.hint.hashCode();
		return 31 * result + this.bits.hashCode();
	}
}