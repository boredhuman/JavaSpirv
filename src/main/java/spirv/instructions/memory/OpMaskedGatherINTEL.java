package spirv.instructions.memory;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpMaskedGatherINTEL implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction ptrVector;
	public int alignment;
	public Instruction mask;
	public Instruction fillEmpty;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.ptrVector = instructions[data[offset + 2]];
		this.alignment = data[offset + 3];
		this.mask = instructions[data[offset + 4]];
		this.fillEmpty = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.ptrVector);
		writer.write(this.alignment);
		writer.write(this.mask);
		writer.write(this.fillEmpty);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MASKED_GATHER_INTEL;
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
		 return new String[] { "MaskedGatherScatterINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMaskedGatherINTEL)) {
			return false;
		}
		OpMaskedGatherINTEL other = (OpMaskedGatherINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.ptrVector.equals(other.ptrVector)) {
			return false;
		}
		if (this.alignment != other.alignment) {
			return false;
		}
		if (!this.mask.equals(other.mask)) {
			return false;
		}
		return this.fillEmpty.equals(other.fillEmpty);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.ptrVector.hashCode();
		result += 31 * result + this.alignment;
		result += 31 * result + this.mask.hashCode();
		return 31 * result + this.fillEmpty.hashCode();
	}
}