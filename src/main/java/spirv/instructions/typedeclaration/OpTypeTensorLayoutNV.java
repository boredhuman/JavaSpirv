package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeTensorLayoutNV implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction dim;
	public Instruction clampMode;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.dim = instructions[data[offset + 1]];
		this.clampMode = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.dim);
		writer.write(this.clampMode);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_TENSOR_LAYOUT_NV;
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
		if (!(o instanceof OpTypeTensorLayoutNV)) {
			return false;
		}
		OpTypeTensorLayoutNV other = (OpTypeTensorLayoutNV) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.dim.equals(other.dim)) {
			return false;
		}
		return this.clampMode.equals(other.clampMode);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.dim.hashCode();
		return 31 * result + this.clampMode.hashCode();
	}
}