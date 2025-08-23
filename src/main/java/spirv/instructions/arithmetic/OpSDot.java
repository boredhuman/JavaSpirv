package spirv.instructions.arithmetic;

import java.util.Objects;
import spirv.enumerants.PackedVectorFormat;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSDot implements ArithmeticInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction vector1;
	public Instruction vector2;
	public PackedVectorFormat packedVectorFormat;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.vector1 = instructions[data[offset + 2]];
		this.vector2 = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.packedVectorFormat = PackedVectorFormat.get(data[offset + 4]);
	}

	@Override
	public int size() {
		int size = 4;
		size += this.packedVectorFormat == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.vector1);
		writer.write(this.vector2);
		if (this.packedVectorFormat != null) {
			writer.write(this.packedVectorFormat);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_S_DOT;
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
		 return new String[] { "DotProduct" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_integer_dot_product" };
	}

	@Override
	public String version() {
		return "1.6";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSDot)) {
			return false;
		}
		OpSDot other = (OpSDot) o;
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
		return Objects.equals(this.packedVectorFormat, other.packedVectorFormat);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.vector1.hashCode();
		result += 31 * result + this.vector2.hashCode();
		return 31 * result + Objects.hashCode(this.packedVectorFormat);
	}
}