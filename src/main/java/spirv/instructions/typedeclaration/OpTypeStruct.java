package spirv.instructions.typedeclaration;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeStruct implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction[] member0Type;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.member0Type = new Instruction[length - 1];
		for (int i = 0; i < this.member0Type.length; i++) {
			this.member0Type[i] = instructions[data[offset + 1 + i]];
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += this.member0Type == null ? 0 : this.member0Type.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		if (this.member0Type != null) {
			writer.write(this.member0Type);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_STRUCT;
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
		if (!(o instanceof OpTypeStruct)) {
			return false;
		}
		OpTypeStruct other = (OpTypeStruct) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.member0Type, other.member0Type);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + Arrays.hashCode(this.member0Type);
	}
}