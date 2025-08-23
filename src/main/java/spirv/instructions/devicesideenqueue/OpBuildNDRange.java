package spirv.instructions.devicesideenqueue;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpBuildNDRange implements DeviceSideEnqueueInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction globalWorkSize;
	public Instruction localWorkSize;
	public Instruction globalWorkOffset;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.globalWorkSize = instructions[data[offset + 2]];
		this.localWorkSize = instructions[data[offset + 3]];
		this.globalWorkOffset = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.globalWorkSize);
		writer.write(this.localWorkSize);
		writer.write(this.globalWorkOffset);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_BUILD_ND_RANGE;
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
		if (!(o instanceof OpBuildNDRange)) {
			return false;
		}
		OpBuildNDRange other = (OpBuildNDRange) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.globalWorkSize.equals(other.globalWorkSize)) {
			return false;
		}
		if (!this.localWorkSize.equals(other.localWorkSize)) {
			return false;
		}
		return this.globalWorkOffset.equals(other.globalWorkOffset);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.globalWorkSize.hashCode();
		result += 31 * result + this.localWorkSize.hashCode();
		return 31 * result + this.globalWorkOffset.hashCode();
	}
}