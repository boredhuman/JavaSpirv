package spirv.instructions.pipe;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGetMaxPipePackets implements PipeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pipe;
	public Instruction packetSize;
	public Instruction packetAlignment;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pipe = instructions[data[offset + 2]];
		this.packetSize = instructions[data[offset + 3]];
		this.packetAlignment = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pipe);
		writer.write(this.packetSize);
		writer.write(this.packetAlignment);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GET_MAX_PIPE_PACKETS;
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
		 return new String[] { "Pipes" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGetMaxPipePackets)) {
			return false;
		}
		OpGetMaxPipePackets other = (OpGetMaxPipePackets) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.pipe.equals(other.pipe)) {
			return false;
		}
		if (!this.packetSize.equals(other.packetSize)) {
			return false;
		}
		return this.packetAlignment.equals(other.packetAlignment);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pipe.hashCode();
		result += 31 * result + this.packetSize.hashCode();
		return 31 * result + this.packetAlignment.hashCode();
	}
}