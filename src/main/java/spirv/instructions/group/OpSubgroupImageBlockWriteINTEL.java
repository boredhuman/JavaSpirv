package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSubgroupImageBlockWriteINTEL implements GroupInstruction {
	public Instruction image;
	public Instruction coordinate;
	public Instruction data;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.image = instructions[data[offset]];
		this.coordinate = instructions[data[offset + 1]];
		this.data = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.image);
		writer.write(this.coordinate);
		writer.write(this.data);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_IMAGE_BLOCK_WRITE_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SubgroupImageBlockIOINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupImageBlockWriteINTEL)) {
			return false;
		}
		OpSubgroupImageBlockWriteINTEL other = (OpSubgroupImageBlockWriteINTEL) o;
		if (!this.image.equals(other.image)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		return this.data.equals(other.data);
	}

	@Override
	public int hashCode() {
		int result = this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		return 31 * result + this.data.hashCode();
	}
}