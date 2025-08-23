package spirv.instructions.typedeclaration;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeTensorViewNV implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction dim;
	public Instruction hasDimensions;
	public Instruction[] p;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.dim = instructions[data[offset + 1]];
		this.hasDimensions = instructions[data[offset + 2]];
		this.p = new Instruction[length - 3];
		for (int i = 0; i < this.p.length; i++) {
			this.p[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.p == null ? 0 : this.p.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.dim);
		writer.write(this.hasDimensions);
		if (this.p != null) {
			writer.write(this.p);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_TENSOR_VIEW_NV;
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
		if (!(o instanceof OpTypeTensorViewNV)) {
			return false;
		}
		OpTypeTensorViewNV other = (OpTypeTensorViewNV) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.dim.equals(other.dim)) {
			return false;
		}
		if (!this.hasDimensions.equals(other.hasDimensions)) {
			return false;
		}
		return Arrays.equals(this.p, other.p);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.dim.hashCode();
		result += 31 * result + this.hasDimensions.hashCode();
		return 31 * result + Arrays.hashCode(this.p);
	}
}