package spirv.instructions.tensor;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTensorQuerySizeARM implements TensorInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction tensor;
	public Instruction dimension;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.tensor = instructions[data[offset + 2]];
		this.dimension = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.tensor);
		writer.write(this.dimension);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_QUERY_SIZE_ARM;
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
		 return new String[] { "TensorsARM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTensorQuerySizeARM)) {
			return false;
		}
		OpTensorQuerySizeARM other = (OpTensorQuerySizeARM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.tensor.equals(other.tensor)) {
			return false;
		}
		return this.dimension.equals(other.dimension);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.tensor.hashCode();
		return 31 * result + this.dimension.hashCode();
	}
}