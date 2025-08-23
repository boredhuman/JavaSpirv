package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGetKernelLocalSizeForSubgroupCount implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction subgroupCount;
	public Instruction invoke;
	public Instruction param;
	public Instruction paramSize;
	public Instruction paramAlign;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.subgroupCount = instructions[data[offset + 2]];
		this.invoke = instructions[data[offset + 3]];
		this.param = instructions[data[offset + 4]];
		this.paramSize = instructions[data[offset + 5]];
		this.paramAlign = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.subgroupCount);
		writer.write(this.invoke);
		writer.write(this.param);
		writer.write(this.paramSize);
		writer.write(this.paramAlign);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GET_KERNEL_LOCAL_SIZE_FOR_SUBGROUP_COUNT;
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
		 return new String[] { "SubgroupDispatch" };
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGetKernelLocalSizeForSubgroupCount)) {
			return false;
		}
		OpGetKernelLocalSizeForSubgroupCount other = (OpGetKernelLocalSizeForSubgroupCount) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.subgroupCount.equals(other.subgroupCount)) {
			return false;
		}
		if (!this.invoke.equals(other.invoke)) {
			return false;
		}
		if (!this.param.equals(other.param)) {
			return false;
		}
		if (!this.paramSize.equals(other.paramSize)) {
			return false;
		}
		return this.paramAlign.equals(other.paramAlign);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.subgroupCount.hashCode();
		result += 31 * result + this.invoke.hashCode();
		result += 31 * result + this.param.hashCode();
		result += 31 * result + this.paramSize.hashCode();
		return 31 * result + this.paramAlign.hashCode();
	}
}