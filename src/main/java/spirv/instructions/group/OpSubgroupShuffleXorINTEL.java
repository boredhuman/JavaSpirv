package spirv.instructions.group;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupShuffleXorINTEL implements GroupInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction data;
	public Instruction value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.data = instructions[data[offset + 2]];
		this.value = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.data);
		writer.write(this.value);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_SHUFFLE_XOR_INTEL;
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
		if (!(o instanceof OpSubgroupShuffleXorINTEL)) {
			return false;
		}
		OpSubgroupShuffleXorINTEL other = (OpSubgroupShuffleXorINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.data.equals(other.data)) {
			return false;
		}
		return this.value.equals(other.value);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.data.hashCode();
		return 31 * result + this.value.hashCode();
	}
}