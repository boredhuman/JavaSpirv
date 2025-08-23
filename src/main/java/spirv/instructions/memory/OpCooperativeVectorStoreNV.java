package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpCooperativeVectorStoreNV implements MemoryInstruction {
	public Instruction pointer;
	public Instruction offset;
	public Instruction object;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.offset = instructions[data[offset + 1]];
		this.object = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.memoryAccess = data[offset + 3];
		this.memoryAccessArg = MemoryAccess.loadArg(this.memoryAccess, data, offset + 4, instructions);
	}

	@Override
	public int size() {
		int size = 3;
		size += this.memoryAccess == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.offset);
		writer.write(this.object);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_VECTOR_STORE_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "CooperativeVectorNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeVectorStoreNV)) {
			return false;
		}
		OpCooperativeVectorStoreNV other = (OpCooperativeVectorStoreNV) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.offset.equals(other.offset)) {
			return false;
		}
		if (!this.object.equals(other.object)) {
			return false;
		}
		if (!Objects.equals(this.memoryAccess, other.memoryAccess)) {
			return false;
		}
		return Arrays.equals(this.memoryAccessArg, other.memoryAccessArg);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.offset.hashCode();
		result += 31 * result + this.object.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		return 31 * result + Arrays.hashCode(this.memoryAccessArg);
	}
}