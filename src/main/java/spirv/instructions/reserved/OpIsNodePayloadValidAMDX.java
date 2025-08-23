package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpIsNodePayloadValidAMDX implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction payloadType;
	public Instruction nodeIndex;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.payloadType = instructions[data[offset + 2]];
		this.nodeIndex = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.payloadType);
		writer.write(this.nodeIndex);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_IS_NODE_PAYLOAD_VALID_AMDX;
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
		 return new String[] { "ShaderEnqueueAMDX" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpIsNodePayloadValidAMDX)) {
			return false;
		}
		OpIsNodePayloadValidAMDX other = (OpIsNodePayloadValidAMDX) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.payloadType.equals(other.payloadType)) {
			return false;
		}
		return this.nodeIndex.equals(other.nodeIndex);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.payloadType.hashCode();
		return 31 * result + this.nodeIndex.hashCode();
	}
}