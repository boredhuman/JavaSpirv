package spirv.instructions.typedeclaration;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeTensorARM implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction elementType;
	public Instruction rank;
	public Instruction shape;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.elementType = instructions[data[offset + 1]];
		if (length - 2 <= 0) {
			return;
		}
		this.rank = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.shape = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		int size = 2;
		size += this.rank == null ? 0 : 1;
		size += this.shape == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.elementType);
		if (this.rank != null) {
			writer.write(this.rank);
		}
		if (this.shape != null) {
			writer.write(this.shape);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_TENSOR_ARM;
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
		if (!(o instanceof OpTypeTensorARM)) {
			return false;
		}
		OpTypeTensorARM other = (OpTypeTensorARM) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.elementType.equals(other.elementType)) {
			return false;
		}
		if (!Objects.equals(this.rank, other.rank)) {
			return false;
		}
		return Objects.equals(this.shape, other.shape);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.elementType.hashCode();
		result += 31 * result + Objects.hashCode(this.rank);
		return 31 * result + Objects.hashCode(this.shape);
	}
}