package spirv.instructions.graph;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpGraphSetOutputARM implements GraphInstruction {
	public Instruction value;
	public Instruction outputIndex;
	public Instruction[] elementIndex;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.value = instructions[data[offset]];
		this.outputIndex = instructions[data[offset + 1]];
		this.elementIndex = new Instruction[length - 2];
		for (int i = 0; i < this.elementIndex.length; i++) {
			this.elementIndex[i] = instructions[data[offset + 2 + i]];
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.elementIndex == null ? 0 : this.elementIndex.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.value);
		writer.write(this.outputIndex);
		if (this.elementIndex != null) {
			writer.write(this.elementIndex);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GRAPH_SET_OUTPUT_ARM;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "GraphARM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGraphSetOutputARM)) {
			return false;
		}
		OpGraphSetOutputARM other = (OpGraphSetOutputARM) o;
		if (!this.value.equals(other.value)) {
			return false;
		}
		if (!this.outputIndex.equals(other.outputIndex)) {
			return false;
		}
		return Arrays.equals(this.elementIndex, other.elementIndex);
	}

	@Override
	public int hashCode() {
		int result = this.value.hashCode();
		result += 31 * result + this.outputIndex.hashCode();
		return 31 * result + Arrays.hashCode(this.elementIndex);
	}
}