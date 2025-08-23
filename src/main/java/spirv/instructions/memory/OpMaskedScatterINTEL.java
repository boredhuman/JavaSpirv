package spirv.instructions.memory;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMaskedScatterINTEL implements MemoryInstruction {
	public Instruction inputVector;
	public Instruction ptrVector;
	public int alignment;
	public Instruction mask;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.inputVector = instructions[data[offset]];
		this.ptrVector = instructions[data[offset + 1]];
		this.alignment = data[offset + 2];
		this.mask = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.inputVector);
		writer.write(this.ptrVector);
		writer.write(this.alignment);
		writer.write(this.mask);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MASKED_SCATTER_INTEL;
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
		if (!(o instanceof OpMaskedScatterINTEL)) {
			return false;
		}
		OpMaskedScatterINTEL other = (OpMaskedScatterINTEL) o;
		if (!this.inputVector.equals(other.inputVector)) {
			return false;
		}
		if (!this.ptrVector.equals(other.ptrVector)) {
			return false;
		}
		if (this.alignment != other.alignment) {
			return false;
		}
		return this.mask.equals(other.mask);
	}

	@Override
	public int hashCode() {
		int result = this.inputVector.hashCode();
		result += 31 * result + this.ptrVector.hashCode();
		result += 31 * result + this.alignment;
		return 31 * result + this.mask.hashCode();
	}
}