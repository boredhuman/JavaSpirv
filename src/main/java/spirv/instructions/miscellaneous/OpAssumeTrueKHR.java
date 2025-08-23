package spirv.instructions.miscellaneous;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpAssumeTrueKHR implements MiscellaneousInstruction {
	public Instruction condition;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.condition = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.condition);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ASSUME_TRUE_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "ExpectAssumeKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_expect_assume" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAssumeTrueKHR)) {
			return false;
		}
		OpAssumeTrueKHR other = (OpAssumeTrueKHR) o;
		return this.condition.equals(other.condition);
	}

	@Override
	public int hashCode() {
		return this.condition.hashCode();
	}
}