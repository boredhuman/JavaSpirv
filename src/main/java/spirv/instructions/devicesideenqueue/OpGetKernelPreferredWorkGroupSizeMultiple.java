package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGetKernelPreferredWorkGroupSizeMultiple implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction invoke;
	public Instruction param;
	public Instruction paramSize;
	public Instruction paramAlign;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.invoke = instructions[data[offset + 2]];
		this.param = instructions[data[offset + 3]];
		this.paramSize = instructions[data[offset + 4]];
		this.paramAlign = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.invoke);
		writer.write(this.param);
		writer.write(this.paramSize);
		writer.write(this.paramAlign);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GET_KERNEL_PREFERRED_WORK_GROUP_SIZE_MULTIPLE;
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
		 return new String[] { "DeviceEnqueue" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGetKernelPreferredWorkGroupSizeMultiple)) {
			return false;
		}
		OpGetKernelPreferredWorkGroupSizeMultiple other = (OpGetKernelPreferredWorkGroupSizeMultiple) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
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
		result += 31 * result + this.invoke.hashCode();
		result += 31 * result + this.param.hashCode();
		result += 31 * result + this.paramSize.hashCode();
		return 31 * result + this.paramAlign.hashCode();
	}
}