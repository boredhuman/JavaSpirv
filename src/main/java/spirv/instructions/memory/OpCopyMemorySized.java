package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpCopyMemorySized implements MemoryInstruction {
	public Instruction target;
	public Instruction source;
	public Instruction size;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;
	@BitMask(MemoryAccess.class)
	public int memoryAccess1;
	public Object[] memoryAccess1Arg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.target = instructions[data[offset]];
		this.source = instructions[data[offset + 1]];
		this.size = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.memoryAccess = data[offset + 3];
		this.memoryAccessArg = MemoryAccess.loadArg(this.memoryAccess, data, offset + 4, instructions);
		int dynamicOffset = MemoryAccess.getArgumentCount(this.memoryAccess) + 4;
		if (length - dynamicOffset <= 0) {
			return;
		}
		this.memoryAccess1 = data[offset + dynamicOffset];
		this.memoryAccess1Arg = MemoryAccess.loadArg(this.memoryAccess1, data, offset + dynamicOffset, instructions);
	}

	@Override
	public int size() {
		int size = 3;
		size += this.memoryAccess == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess);
		size += this.memoryAccess1 == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess1);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.target);
		writer.write(this.source);
		writer.write(this.size);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
		if (this.memoryAccess1 > 0) {
			writer.write(this.memoryAccess1);
			writer.write(this.memoryAccess1Arg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COPY_MEMORY_SIZED;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Addresses", "UntypedPointersKHR" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCopyMemorySized)) {
			return false;
		}
		OpCopyMemorySized other = (OpCopyMemorySized) o;
		if (!this.target.equals(other.target)) {
			return false;
		}
		if (!this.source.equals(other.source)) {
			return false;
		}
		if (!this.size.equals(other.size)) {
			return false;
		}
		if (!Objects.equals(this.memoryAccess, other.memoryAccess)) {
			return false;
		}
		if (!Arrays.equals(this.memoryAccessArg, other.memoryAccessArg)) {
			return false;
		}
		if (!Objects.equals(this.memoryAccess1, other.memoryAccess1)) {
			return false;
		}
		return Arrays.equals(this.memoryAccess1Arg, other.memoryAccess1Arg);
	}

	@Override
	public int hashCode() {
		int result = this.target.hashCode();
		result += 31 * result + this.source.hashCode();
		result += 31 * result + this.size.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		result += 31 * result + Arrays.hashCode(this.memoryAccessArg);
		result += 31 * result + Objects.hashCode(this.memoryAccess1);
		return 31 * result + Arrays.hashCode(this.memoryAccess1Arg);
	}
}