package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSubgroupBlockWriteINTEL implements GroupInstruction {
	public Instruction ptr;
	public Instruction data;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.ptr = instructions[data[offset]];
		this.data = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.ptr);
		writer.write(this.data);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_BLOCK_WRITE_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SubgroupBufferBlockIOINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupBlockWriteINTEL)) {
			return false;
		}
		OpSubgroupBlockWriteINTEL other = (OpSubgroupBlockWriteINTEL) o;
		if (!this.ptr.equals(other.ptr)) {
			return false;
		}
		return this.data.equals(other.data);
	}

	@Override
	public int hashCode() {
		int result = this.ptr.hashCode();
		return 31 * result + this.data.hashCode();
	}
}