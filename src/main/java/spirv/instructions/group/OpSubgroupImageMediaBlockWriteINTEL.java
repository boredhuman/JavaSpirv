package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSubgroupImageMediaBlockWriteINTEL implements GroupInstruction {
	public Instruction image;
	public Instruction coordinate;
	public Instruction width;
	public Instruction height;
	public Instruction data;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.image = instructions[data[offset]];
		this.coordinate = instructions[data[offset + 1]];
		this.width = instructions[data[offset + 2]];
		this.height = instructions[data[offset + 3]];
		this.data = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.image);
		writer.write(this.coordinate);
		writer.write(this.width);
		writer.write(this.height);
		writer.write(this.data);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_IMAGE_MEDIA_BLOCK_WRITE_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SubgroupImageMediaBlockIOINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupImageMediaBlockWriteINTEL)) {
			return false;
		}
		OpSubgroupImageMediaBlockWriteINTEL other = (OpSubgroupImageMediaBlockWriteINTEL) o;
		if (!this.image.equals(other.image)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		if (!this.width.equals(other.width)) {
			return false;
		}
		if (!this.height.equals(other.height)) {
			return false;
		}
		return this.data.equals(other.data);
	}

	@Override
	public int hashCode() {
		int result = this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		result += 31 * result + this.width.hashCode();
		result += 31 * result + this.height.hashCode();
		return 31 * result + this.data.hashCode();
	}
}