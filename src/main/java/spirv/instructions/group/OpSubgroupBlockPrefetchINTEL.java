package spirv.instructions.group;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpSubgroupBlockPrefetchINTEL implements GroupInstruction {
	public Instruction ptr;
	public Instruction numBytes;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.ptr = instructions[data[offset]];
		this.numBytes = instructions[data[offset + 1]];
		if (length - 2 <= 0) {
			return;
		}
		this.memoryAccess = data[offset + 2];
		this.memoryAccessArg = MemoryAccess.loadArg(this.memoryAccess, data, offset + 3, instructions);
	}

	@Override
	public int size() {
		int size = 2;
		size += this.memoryAccess == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.ptr);
		writer.write(this.numBytes);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_BLOCK_PREFETCH_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SubgroupBufferPrefetchINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupBlockPrefetchINTEL)) {
			return false;
		}
		OpSubgroupBlockPrefetchINTEL other = (OpSubgroupBlockPrefetchINTEL) o;
		if (!this.ptr.equals(other.ptr)) {
			return false;
		}
		if (!this.numBytes.equals(other.numBytes)) {
			return false;
		}
		if (!Objects.equals(this.memoryAccess, other.memoryAccess)) {
			return false;
		}
		return Arrays.equals(this.memoryAccessArg, other.memoryAccessArg);
	}

	@Override
	public int hashCode() {
		int result = this.ptr.hashCode();
		result += 31 * result + this.numBytes.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		return 31 * result + Arrays.hashCode(this.memoryAccessArg);
	}
}