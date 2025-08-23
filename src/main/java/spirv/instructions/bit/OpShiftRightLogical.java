package spirv.instructions.bit;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpShiftRightLogical implements BitInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction base;
	public Instruction shift;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.base = instructions[data[offset + 2]];
		this.shift = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.base);
		writer.write(this.shift);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SHIFT_RIGHT_LOGICAL;
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
		if (!(o instanceof OpShiftRightLogical)) {
			return false;
		}
		OpShiftRightLogical other = (OpShiftRightLogical) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.base.equals(other.base)) {
			return false;
		}
		return this.shift.equals(other.shift);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.base.hashCode();
		return 31 * result + this.shift.hashCode();
	}
}