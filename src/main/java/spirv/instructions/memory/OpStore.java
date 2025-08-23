package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpStore implements MemoryInstruction {
	public Instruction pointer;
	public Instruction object;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.object = instructions[data[offset + 1]];
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
		writer.write(this.pointer);
		writer.write(this.object);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_STORE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpStore)) {
			return false;
		}
		OpStore other = (OpStore) o;
		if (!this.pointer.equals(other.pointer)) {
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
		result += 31 * result + this.object.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		return 31 * result + Arrays.hashCode(this.memoryAccessArg);
	}
}