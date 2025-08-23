package spirv.instructions.barrier;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpNamedBarrierInitialize implements BarrierInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction subgroupCount;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.subgroupCount = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.subgroupCount);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_NAMED_BARRIER_INITIALIZE;
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
		 return new String[] { "NamedBarrier" };
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpNamedBarrierInitialize)) {
			return false;
		}
		OpNamedBarrierInitialize other = (OpNamedBarrierInitialize) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.subgroupCount.equals(other.subgroupCount);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + this.subgroupCount.hashCode();
	}
}