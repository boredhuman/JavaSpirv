package spirv.instructions.reserved;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpCooperativeVectorOuterProductAccumulateNV implements ReservedInstruction {
	public Instruction pointer;
	public Instruction offset;
	public Instruction a;
	public Instruction b;
	public Instruction memoryLayout;
	public Instruction matrixInterpretation;
	public Instruction matrixStride;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointer = instructions[data[offset]];
		this.offset = instructions[data[offset + 1]];
		this.a = instructions[data[offset + 2]];
		this.b = instructions[data[offset + 3]];
		this.memoryLayout = instructions[data[offset + 4]];
		this.matrixInterpretation = instructions[data[offset + 5]];
		if (length - 6 <= 0) {
			return;
		}
		this.matrixStride = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		int size = 6;
		size += this.matrixStride == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointer);
		writer.write(this.offset);
		writer.write(this.a);
		writer.write(this.b);
		writer.write(this.memoryLayout);
		writer.write(this.matrixInterpretation);
		if (this.matrixStride != null) {
			writer.write(this.matrixStride);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_VECTOR_OUTER_PRODUCT_ACCUMULATE_NV;
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
		if (!(o instanceof OpCooperativeVectorOuterProductAccumulateNV)) {
			return false;
		}
		OpCooperativeVectorOuterProductAccumulateNV other = (OpCooperativeVectorOuterProductAccumulateNV) o;
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.offset.equals(other.offset)) {
			return false;
		}
		if (!this.a.equals(other.a)) {
			return false;
		}
		if (!this.b.equals(other.b)) {
			return false;
		}
		if (!this.memoryLayout.equals(other.memoryLayout)) {
			return false;
		}
		if (!this.matrixInterpretation.equals(other.matrixInterpretation)) {
			return false;
		}
		return Objects.equals(this.matrixStride, other.matrixStride);
	}

	@Override
	public int hashCode() {
		int result = this.pointer.hashCode();
		result += 31 * result + this.offset.hashCode();
		result += 31 * result + this.a.hashCode();
		result += 31 * result + this.b.hashCode();
		result += 31 * result + this.memoryLayout.hashCode();
		result += 31 * result + this.matrixInterpretation.hashCode();
		return 31 * result + Objects.hashCode(this.matrixStride);
	}
}