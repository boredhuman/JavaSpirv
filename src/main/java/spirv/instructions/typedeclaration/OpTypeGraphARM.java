package spirv.instructions.typedeclaration;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeGraphARM implements TypeDeclarationInstruction, Result {
	public int idResult;
	public int numInputs;
	public Instruction[] inOutTypes;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.numInputs = data[offset + 1];
		this.inOutTypes = new Instruction[length - 2];
		for (int i = 0; i < this.inOutTypes.length; i++) {
			this.inOutTypes[i] = instructions[data[offset + 2 + i]];
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.inOutTypes == null ? 0 : this.inOutTypes.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.numInputs);
		if (this.inOutTypes != null) {
			writer.write(this.inOutTypes);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_GRAPH_ARM;
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
		if (!(o instanceof OpTypeGraphARM)) {
			return false;
		}
		OpTypeGraphARM other = (OpTypeGraphARM) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.numInputs != other.numInputs) {
			return false;
		}
		return Arrays.equals(this.inOutTypes, other.inOutTypes);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.numInputs;
		return 31 * result + Arrays.hashCode(this.inOutTypes);
	}
}