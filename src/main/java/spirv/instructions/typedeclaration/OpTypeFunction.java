package spirv.instructions.typedeclaration;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeFunction implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction returnType;
	public Instruction[] parameter0Type;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.returnType = instructions[data[offset + 1]];
		this.parameter0Type = new Instruction[length - 2];
		for (int i = 0; i < this.parameter0Type.length; i++) {
			this.parameter0Type[i] = instructions[data[offset + 2 + i]];
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.parameter0Type == null ? 0 : this.parameter0Type.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.returnType);
		if (this.parameter0Type != null) {
			writer.write(this.parameter0Type);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_FUNCTION;
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
		if (!(o instanceof OpTypeFunction)) {
			return false;
		}
		OpTypeFunction other = (OpTypeFunction) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.returnType.equals(other.returnType)) {
			return false;
		}
		return Arrays.equals(this.parameter0Type, other.parameter0Type);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.returnType.hashCode();
		return 31 * result + Arrays.hashCode(this.parameter0Type);
	}
}