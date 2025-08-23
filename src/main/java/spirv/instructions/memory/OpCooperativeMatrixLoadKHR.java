package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeMatrixLoadKHR implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pointer;
	public Instruction memoryLayout;
	public Instruction stride;
	@BitMask(MemoryAccess.class)
	public int memoryOperand;
	public Object[] memoryOperandArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pointer = instructions[data[offset + 2]];
		this.memoryLayout = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.stride = instructions[data[offset + 4]];
		if (length - 5 <= 0) {
			return;
		}
		this.memoryOperand = data[offset + 5];
		this.memoryOperandArg = MemoryAccess.loadArg(this.memoryOperand, data, offset + 6, instructions);
	}

	@Override
	public int size() {
		int size = 4;
		size += this.stride == null ? 0 : 1;
		size += this.memoryOperand == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryOperand);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pointer);
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
		return OpCodes.OP_COOPERATIVE_MATRIX_LOAD_KHR;
	}

	@Override
	public Instruction resultType() {
		return this.idResultType;
	}

	@Override
	public void setResultType(Instruction resultType) {
		this.idResultType = resultType;
	}

	@Override
	public int result() {
		return this.idResult;
	}

	@Override
	public void setResult(int result) {
		this.idResult = result;
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
		if (!(o instanceof OpCooperativeMatrixLoadKHR)) {
			return false;
		}
		OpCooperativeMatrixLoadKHR other = (OpCooperativeMatrixLoadKHR) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.pointer.equals(other.pointer)) {
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
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pointer.hashCode();
		result += 31 * result + this.memoryLayout.hashCode();
		result += 31 * result + Objects.hashCode(this.stride);
		result += 31 * result + Objects.hashCode(this.memoryOperand);
		return 31 * result + Arrays.hashCode(this.memoryOperandArg);
	}
}