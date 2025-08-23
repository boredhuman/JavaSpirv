package spirv.instructions.memory;

import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.TensorAddressingOperands;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;

public class OpCooperativeMatrixStoreTensorNV implements MemoryInstruction {
	public Instruction pointer;
	public Instruction object;
	public Instruction tensorLayout;
	@BitMask(MemoryAccess.class)
	public int memoryOperand;
	public Object[] memoryOperandArg;
	@BitMask(TensorAddressingOperands.class)
	public int tensorAddressingOperands;
	public Instruction[] tensorAddressingOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.object = instructions[data[offset + 1]];
		this.tensorLayout = instructions[data[offset + 2]];
		this.memoryOperand = data[offset + 3];
		this.memoryOperandArg = MemoryAccess.loadArg(this.memoryOperand, data, offset + 4, instructions);
		int dynamicOffset = MemoryAccess.getArgumentCount(this.memoryOperand) + 4;
		this.tensorAddressingOperands = data[offset + dynamicOffset];
		this.tensorAddressingOperandsArg = new Instruction[TensorAddressingOperands.getArgumentCount(this.tensorAddressingOperands)];
		for (int i = 0; i < this.tensorAddressingOperandsArg.length; i++) {
			this.tensorAddressingOperandsArg[i] = instructions[data[offset + dynamicOffset + i]];
		}
	}

	@Override
	public int size() {
		int size = 5;
		size += MemoryAccess.getArgumentCount(this.memoryOperand);
		size += TensorAddressingOperands.getArgumentCount(this.tensorAddressingOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.object);
		writer.write(this.tensorLayout);
		writer.write(this.memoryOperand);
		if (this.memoryOperand > 0) {
			writer.write(this.memoryOperandArg);
		}
		writer.write(this.tensorAddressingOperands);
		if (this.tensorAddressingOperands > 0) {
			writer.write(this.tensorAddressingOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_MATRIX_STORE_TENSOR_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "CooperativeMatrixTensorAddressingNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeMatrixStoreTensorNV)) {
			return false;
		}
		OpCooperativeMatrixStoreTensorNV other = (OpCooperativeMatrixStoreTensorNV) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.object.equals(other.object)) {
			return false;
		}
		if (!this.tensorLayout.equals(other.tensorLayout)) {
			return false;
		}
		if (this.memoryOperand != other.memoryOperand) {
			return false;
		}
		if (!Arrays.equals(this.memoryOperandArg, other.memoryOperandArg)) {
			return false;
		}
		if (this.tensorAddressingOperands != other.tensorAddressingOperands) {
			return false;
		}
		return Arrays.equals(this.tensorAddressingOperandsArg, other.tensorAddressingOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.object.hashCode();
		result += 31 * result + this.tensorLayout.hashCode();
		result += 31 * result + this.memoryOperand;
		result += 31 * result + Arrays.hashCode(this.memoryOperandArg);
		result += 31 * result + this.tensorAddressingOperands;
		return 31 * result + Arrays.hashCode(this.tensorAddressingOperandsArg);
	}
}