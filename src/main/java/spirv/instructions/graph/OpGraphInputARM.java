package spirv.instructions.graph;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGraphInputARM implements GraphInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction inputIndex;
	public Instruction[] elementIndex;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.inputIndex = instructions[data[offset + 2]];
		this.elementIndex = new Instruction[length - 3];
		for (int i = 0; i < this.elementIndex.length; i++) {
			this.elementIndex[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.elementIndex == null ? 0 : this.elementIndex.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.inputIndex);
		if (this.elementIndex != null) {
			writer.write(this.elementIndex);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GRAPH_INPUT_ARM;
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
		 return new String[] { "GraphARM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGraphInputARM)) {
			return false;
		}
		OpGraphInputARM other = (OpGraphInputARM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.inputIndex.equals(other.inputIndex)) {
			return false;
		}
		return Arrays.equals(this.elementIndex, other.elementIndex);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.inputIndex.hashCode();
		return 31 * result + Arrays.hashCode(this.elementIndex);
	}
}