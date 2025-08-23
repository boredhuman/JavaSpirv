package spirv.instructions.reserved;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTensorLayoutSetBlockSizeNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction tensorLayout;
	public Instruction[] blockSize;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.tensorLayout = instructions[data[offset + 2]];
		this.blockSize = new Instruction[length - 3];
		for (int i = 0; i < this.blockSize.length; i++) {
			this.blockSize[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.blockSize == null ? 0 : this.blockSize.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.tensorLayout);
		if (this.blockSize != null) {
			writer.write(this.blockSize);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_LAYOUT_SET_BLOCK_SIZE_NV;
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
		 return new String[] { "TensorAddressingNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTensorLayoutSetBlockSizeNV)) {
			return false;
		}
		OpTensorLayoutSetBlockSizeNV other = (OpTensorLayoutSetBlockSizeNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.tensorLayout.equals(other.tensorLayout)) {
			return false;
		}
		return Arrays.equals(this.blockSize, other.blockSize);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.tensorLayout.hashCode();
		return 31 * result + Arrays.hashCode(this.blockSize);
	}
}