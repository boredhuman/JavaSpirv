package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupShuffleDownINTEL implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction current;
	public Instruction next;
	public Instruction delta;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.current = instructions[data[offset + 2]];
		this.next = instructions[data[offset + 3]];
		this.delta = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.current);
		writer.write(this.next);
		writer.write(this.delta);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_SHUFFLE_DOWN_INTEL;
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
		 return new String[] { "SubgroupShuffleINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupShuffleDownINTEL)) {
			return false;
		}
		OpSubgroupShuffleDownINTEL other = (OpSubgroupShuffleDownINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.current.equals(other.current)) {
			return false;
		}
		if (!this.next.equals(other.next)) {
			return false;
		}
		return this.delta.equals(other.delta);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.current.hashCode();
		result += 31 * result + this.next.hashCode();
		return 31 * result + this.delta.hashCode();
	}
}