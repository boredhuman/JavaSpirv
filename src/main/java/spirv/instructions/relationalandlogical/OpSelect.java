package spirv.instructions.relationalandlogical;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSelect implements RelationalandLogicalInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction condition;
	public Instruction object1;
	public Instruction object2;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.condition = instructions[data[offset + 2]];
		this.object1 = instructions[data[offset + 3]];
		this.object2 = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.condition);
		writer.write(this.object1);
		writer.write(this.object2);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SELECT;
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
		if (!(o instanceof OpSelect)) {
			return false;
		}
		OpSelect other = (OpSelect) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.condition.equals(other.condition)) {
			return false;
		}
		if (!this.object1.equals(other.object1)) {
			return false;
		}
		return this.object2.equals(other.object2);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.condition.hashCode();
		result += 31 * result + this.object1.hashCode();
		return 31 * result + this.object2.hashCode();
	}
}