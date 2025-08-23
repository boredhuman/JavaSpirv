package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCreateUserEvent implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CREATE_USER_EVENT;
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
		if (!(o instanceof OpCreateUserEvent)) {
			return false;
		}
		OpCreateUserEvent other = (OpCreateUserEvent) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		return this.idResult != other.idResult;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		return 31 * result + this.idResult;
	}
}