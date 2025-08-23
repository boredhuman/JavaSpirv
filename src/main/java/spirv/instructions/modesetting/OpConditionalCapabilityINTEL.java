package spirv.instructions.modesetting;

import spirv.enumerants.Capability;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpConditionalCapabilityINTEL implements ModeSettingInstruction {
	public Instruction condition;
	public Capability capability;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.condition = instructions[data[offset]];
		this.capability = Capability.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.condition);
		writer.write(this.capability);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONDITIONAL_CAPABILITY_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SpecConditionalINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConditionalCapabilityINTEL)) {
			return false;
		}
		OpConditionalCapabilityINTEL other = (OpConditionalCapabilityINTEL) o;
		if (!this.condition.equals(other.condition)) {
			return false;
		}
		return this.capability != other.capability;
	}

	@Override
	public int hashCode() {
		int result = this.condition.hashCode();
		return 31 * result + this.capability.hashCode();
	}
}