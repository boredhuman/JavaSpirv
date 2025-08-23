package spirv.instructions.extension;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpExtInst implements ExtensionInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction set;
	public int instruction;
	public Instruction[] operand1;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.set = instructions[data[offset + 2]];
		this.instruction = data[offset + 3];
		this.operand1 = new Instruction[length - 4];
		for (int i = 0; i < this.operand1.length; i++) {
			this.operand1[i] = instructions[data[offset + 4 + i]];
		}
	}

	@Override
	public int size() {
		int size = 4;
		size += this.operand1 == null ? 0 : this.operand1.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.set);
		writer.write(this.instruction);
		if (this.operand1 != null) {
			writer.write(this.operand1);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXT_INST;
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
		if (!(o instanceof OpExtInst)) {
			return false;
		}
		OpExtInst other = (OpExtInst) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.set.equals(other.set)) {
			return false;
		}
		if (this.instruction != other.instruction) {
			return false;
		}
		return Arrays.equals(this.operand1, other.operand1);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.set.hashCode();
		result += 31 * result + this.instruction;
		return 31 * result + Arrays.hashCode(this.operand1);
	}
}