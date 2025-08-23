package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSamplerImageAddressingModeNV implements ReservedInstruction {
	public int bitWidth;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.bitWidth = data[offset];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.bitWidth);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SAMPLER_IMAGE_ADDRESSING_MODE_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "BindlessTextureNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSamplerImageAddressingModeNV)) {
			return false;
		}
		OpSamplerImageAddressingModeNV other = (OpSamplerImageAddressingModeNV) o;
		return this.bitWidth != other.bitWidth;
	}

	@Override
	public int hashCode() {
		return this.bitWidth;
	}
}