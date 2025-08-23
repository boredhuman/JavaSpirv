package spirv.instructions.reserved;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTensorViewSetStrideNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction tensorView;
	public Instruction[] stride;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.tensorView = instructions[data[offset + 2]];
		this.stride = new Instruction[length - 3];
		for (int i = 0; i < this.stride.length; i++) {
			this.stride[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.stride == null ? 0 : this.stride.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.tensorView);
		if (this.stride != null) {
			writer.write(this.stride);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_VIEW_SET_STRIDE_NV;
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
		if (!(o instanceof OpTensorViewSetStrideNV)) {
			return false;
		}
		OpTensorViewSetStrideNV other = (OpTensorViewSetStrideNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.tensorView.equals(other.tensorView)) {
			return false;
		}
		return Arrays.equals(this.stride, other.stride);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.tensorView.hashCode();
		return 31 * result + Arrays.hashCode(this.stride);
	}
}