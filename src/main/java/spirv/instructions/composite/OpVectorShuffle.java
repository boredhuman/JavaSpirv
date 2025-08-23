package spirv.instructions.composite;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpVectorShuffle implements CompositeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction vector1;
	public Instruction vector2;
	public int[] components;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.vector1 = instructions[data[offset + 2]];
		this.vector2 = instructions[data[offset + 3]];
		this.components = new int[length - 4];
		for (int i = 0; i < this.components.length; i++) {
			this.components[i] = data[offset + 4 + i];
		}
	}

	@Override
	public int size() {
		int size = 4;
		size += this.components == null ? 0 : this.components.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.vector1);
		writer.write(this.vector2);
		if (this.components != null) {
			writer.write(this.components);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_VECTOR_SHUFFLE;
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
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpVectorShuffle)) {
			return false;
		}
		OpVectorShuffle other = (OpVectorShuffle) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.vector1.equals(other.vector1)) {
			return false;
		}
		if (!this.vector2.equals(other.vector2)) {
			return false;
		}
		return Arrays.equals(this.components, other.components);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.vector1.hashCode();
		result += 31 * result + this.vector2.hashCode();
		return 31 * result + Arrays.hashCode(this.components);
	}
}