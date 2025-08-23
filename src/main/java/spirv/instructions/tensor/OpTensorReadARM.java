package spirv.instructions.tensor;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.TensorOperands;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTensorReadARM implements TensorInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction tensor;
	public Instruction coordinates;
	@BitMask(TensorOperands.class)
	public int tensorOperands;
	public Instruction[] tensorOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.tensor = instructions[data[offset + 2]];
		this.coordinates = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.tensorOperands = data[offset + 4];
		this.tensorOperandsArg = new Instruction[TensorOperands.getArgumentCount(this.tensorOperands)];
		for (int i = 0; i < this.tensorOperandsArg.length; i++) {
			this.tensorOperandsArg[i] = instructions[data[offset + 5 + i]];
		}
	}

	@Override
	public int size() {
		int size = 4;
		size += this.tensorOperands == 0 ? 0 : 1;
		size += TensorOperands.getArgumentCount(this.tensorOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.tensor);
		writer.write(this.coordinates);
		if (this.tensorOperands > 0) {
			writer.write(this.tensorOperands);
			writer.write(this.tensorOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_READ_ARM;
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
		if (!(o instanceof OpTensorReadARM)) {
			return false;
		}
		OpTensorReadARM other = (OpTensorReadARM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.tensor.equals(other.tensor)) {
			return false;
		}
		if (!this.coordinates.equals(other.coordinates)) {
			return false;
		}
		if (!Objects.equals(this.tensorOperands, other.tensorOperands)) {
			return false;
		}
		return Arrays.equals(this.tensorOperandsArg, other.tensorOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.tensor.hashCode();
		result += 31 * result + this.coordinates.hashCode();
		result += 31 * result + Objects.hashCode(this.tensorOperands);
		return 31 * result + Arrays.hashCode(this.tensorOperandsArg);
	}
}