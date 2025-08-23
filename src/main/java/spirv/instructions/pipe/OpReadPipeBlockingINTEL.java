package spirv.instructions.pipe;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpReadPipeBlockingINTEL implements PipeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction packetSize;
	public Instruction packetAlignment;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.packetSize = instructions[data[offset + 2]];
		this.packetAlignment = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.packetSize);
		writer.write(this.packetAlignment);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_READ_PIPE_BLOCKING_INTEL;
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
		 return new String[] { "BlockingPipesINTEL" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_INTEL_blocking_pipes" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpReadPipeBlockingINTEL)) {
			return false;
		}
		OpReadPipeBlockingINTEL other = (OpReadPipeBlockingINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
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
		result += 31 * result + this.packetSize.hashCode();
		return 31 * result + this.packetAlignment.hashCode();
	}
}