package spirv.instructions.modesetting;

import spirv.enumerants.Capability;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpCapability implements ModeSettingInstruction {
	public Capability capability;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.capability = Capability.get(data[offset]);
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.capability);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CAPABILITY;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCapability)) {
			return false;
		}
		OpCapability other = (OpCapability) o;
		return this.capability != other.capability;
	}

	@Override
	public int hashCode() {
		return this.capability.hashCode();
	}
}