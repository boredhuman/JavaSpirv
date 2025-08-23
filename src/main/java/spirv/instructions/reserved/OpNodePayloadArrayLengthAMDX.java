package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpNodePayloadArrayLengthAMDX implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction payloadArray;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.payloadArray = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.payloadArray);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_NODE_PAYLOAD_ARRAY_LENGTH_AMDX;
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
		if (!(o instanceof OpNodePayloadArrayLengthAMDX)) {
			return false;
		}
		OpNodePayloadArrayLengthAMDX other = (OpNodePayloadArrayLengthAMDX) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.payloadArray.equals(other.payloadArray);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + this.payloadArray.hashCode();
	}
}