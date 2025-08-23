package spirv.instructions.typedeclaration;

import java.util.Objects;
import spirv.enumerants.FPEncoding;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeFloat implements TypeDeclarationInstruction, Result {
	public int idResult;
	public int width;
	public FPEncoding floatingPointEncoding;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.width = data[offset + 1];
		if (length - 2 <= 0) {
			return;
		}
		this.floatingPointEncoding = FPEncoding.get(data[offset + 2]);
	}

	@Override
	public int size() {
		int size = 2;
		size += this.floatingPointEncoding == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.width);
		if (this.floatingPointEncoding != null) {
			writer.write(this.floatingPointEncoding);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_FLOAT;
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
		if (!(o instanceof OpTypeFloat)) {
			return false;
		}
		OpTypeFloat other = (OpTypeFloat) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.width != other.width) {
			return false;
		}
		return Objects.equals(this.floatingPointEncoding, other.floatingPointEncoding);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.width;
		return 31 * result + Objects.hashCode(this.floatingPointEncoding);
	}
}