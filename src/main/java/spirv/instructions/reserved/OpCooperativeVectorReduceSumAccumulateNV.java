package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpCooperativeVectorReduceSumAccumulateNV implements ReservedInstruction {
	public Instruction pointer;
	public Instruction offset;
	public Instruction v;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.offset = instructions[data[offset + 1]];
		this.v = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.offset);
		writer.write(this.v);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_VECTOR_REDUCE_SUM_ACCUMULATE_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "CooperativeVectorTrainingNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeVectorReduceSumAccumulateNV)) {
			return false;
		}
		OpCooperativeVectorReduceSumAccumulateNV other = (OpCooperativeVectorReduceSumAccumulateNV) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.offset.equals(other.offset)) {
			return false;
		}
		return this.v.equals(other.v);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.offset.hashCode();
		return 31 * result + this.v.hashCode();
	}
}