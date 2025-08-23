package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpCooperativeMatrixStoreKHR implements MemoryInstruction {
	public Instruction pointer;
	public Instruction object;
	public Instruction memoryLayout;
	public Instruction stride;
	@BitMask(MemoryAccess.class)
	public int memoryOperand;
	public Object[] memoryOperandArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.object = instructions[data[offset + 1]];
		this.memoryLayout = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.stride = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.memoryOperand = data[offset + 4];
		this.memoryOperandArg = MemoryAccess.loadArg(this.memoryOperand, data, offset + 5, instructions);
	}

	@Override
	public int size() {
		int size = 3;
		size += this.stride == null ? 0 : 1;
		size += this.memoryOperand == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryOperand);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.object);
		writer.write(this.memoryLayout);
		if (this.stride != null) {
			writer.write(this.stride);
		}
		if (this.memoryOperand > 0) {
			writer.write(this.memoryOperand);
			writer.write(this.memoryOperandArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_STORE_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "CooperativeMatrixKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixStoreKHR)) {
			return false;
		}
		OpCooperativeMatrixStoreKHR other = (OpCooperativeMatrixStoreKHR) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.object.equals(other.object)) {
			return false;
		}
		if (!this.memoryLayout.equals(other.memoryLayout)) {
			return false;
		}
		if (!Objects.equals(this.stride, other.stride)) {
			return false;
		}
		if (!Objects.equals(this.memoryOperand, other.memoryOperand)) {
			return false;
		}
		return Arrays.equals(this.memoryOperandArg, other.memoryOperandArg);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.object.hashCode();
		result += 31 * result + this.memoryLayout.hashCode();
		result += 31 * result + Objects.hashCode(this.stride);
		result += 31 * result + Objects.hashCode(this.memoryOperand);
		return 31 * result + Arrays.hashCode(this.memoryOperandArg);
	}
}