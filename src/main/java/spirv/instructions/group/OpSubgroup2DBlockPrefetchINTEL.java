package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSubgroup2DBlockPrefetchINTEL implements GroupInstruction {
	public Instruction elementSize;
	public Instruction blockWidth;
	public Instruction blockHeight;
	public Instruction blockCount;
	public Instruction srcBasePointer;
	public Instruction memoryWidth;
	public Instruction memoryHeight;
	public Instruction memoryPitch;
	public Instruction coordinate;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.elementSize = instructions[data[offset]];
		this.blockWidth = instructions[data[offset + 1]];
		this.blockHeight = instructions[data[offset + 2]];
		this.blockCount = instructions[data[offset + 3]];
		this.srcBasePointer = instructions[data[offset + 4]];
		this.memoryWidth = instructions[data[offset + 5]];
		this.memoryHeight = instructions[data[offset + 6]];
		this.memoryPitch = instructions[data[offset + 7]];
		this.coordinate = instructions[data[offset + 8]];
	}

	@Override
	public int size() {
		return 9;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.elementSize);
		writer.write(this.blockWidth);
		writer.write(this.blockHeight);
		writer.write(this.blockCount);
		writer.write(this.srcBasePointer);
		writer.write(this.memoryWidth);
		writer.write(this.memoryHeight);
		writer.write(this.memoryPitch);
		writer.write(this.coordinate);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP2D_BLOCK_PREFETCH_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Subgroup2DBlockIOINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroup2DBlockPrefetchINTEL)) {
			return false;
		}
		OpSubgroup2DBlockPrefetchINTEL other = (OpSubgroup2DBlockPrefetchINTEL) o;
		if (!this.elementSize.equals(other.elementSize)) {
			return false;
		}
		if (!this.blockWidth.equals(other.blockWidth)) {
			return false;
		}
		if (!this.blockHeight.equals(other.blockHeight)) {
			return false;
		}
		if (!this.blockCount.equals(other.blockCount)) {
			return false;
		}
		if (!this.srcBasePointer.equals(other.srcBasePointer)) {
			return false;
		}
		if (!this.memoryWidth.equals(other.memoryWidth)) {
			return false;
		}
		if (!this.memoryHeight.equals(other.memoryHeight)) {
			return false;
		}
		if (!this.memoryPitch.equals(other.memoryPitch)) {
			return false;
		}
		return this.coordinate.equals(other.coordinate);
	}

	@Override
	public int hashCode() {
		int result = this.elementSize.hashCode();
		result += 31 * result + this.blockWidth.hashCode();
		result += 31 * result + this.blockHeight.hashCode();
		result += 31 * result + this.blockCount.hashCode();
		result += 31 * result + this.srcBasePointer.hashCode();
		result += 31 * result + this.memoryWidth.hashCode();
		result += 31 * result + this.memoryHeight.hashCode();
		result += 31 * result + this.memoryPitch.hashCode();
		return 31 * result + this.coordinate.hashCode();
	}
}