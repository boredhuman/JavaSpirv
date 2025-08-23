package spirv.instructions.reserved;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpCooperativeMatrixStoreNV implements ReservedInstruction {
	public Instruction pointer;
	public Instruction object;
	public Instruction stride;
	public Instruction columnMajor;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.object = instructions[data[offset + 1]];
		this.stride = instructions[data[offset + 2]];
		this.columnMajor = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.memoryAccess = data[offset + 4];
		this.memoryAccessArg = MemoryAccess.loadArg(this.memoryAccess, data, offset + 5, instructions);
	}

	@Override
	public int size() {
		int size = 4;
		size += this.memoryAccess == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.object);
		writer.write(this.stride);
		writer.write(this.columnMajor);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_STORE_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "CooperativeMatrixNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_cooperative_matrix" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixStoreNV)) {
			return false;
		}
		OpCooperativeMatrixStoreNV other = (OpCooperativeMatrixStoreNV) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.object.equals(other.object)) {
			return false;
		}
		if (!this.stride.equals(other.stride)) {
			return false;
		}
		if (!this.columnMajor.equals(other.columnMajor)) {
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
		result += 31 * result + this.stride.hashCode();
		result += 31 * result + this.columnMajor.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		return 31 * result + Arrays.hashCode(this.memoryAccessArg);
	}
}