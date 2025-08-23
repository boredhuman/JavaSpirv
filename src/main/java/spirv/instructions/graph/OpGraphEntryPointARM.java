package spirv.instructions.graph;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpGraphEntryPointARM implements GraphInstruction {
	public Instruction graph;
	public String name;
	public Instruction[] interfaceOperand;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.graph = instructions[data[offset]];
		this.name = InstructionUtil.readString(data, offset + 1).getString();
		int dynamicOffset = InstructionUtil.wordCount(this.name) + 1;
		this.interfaceOperand = new Instruction[length - dynamicOffset];
		for (int i = 0; i < this.interfaceOperand.length; i++) {
			this.interfaceOperand[i] = instructions[data[offset + dynamicOffset + i]];
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.name);
		size += this.interfaceOperand == null ? 0 : this.interfaceOperand.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.graph);
		writer.write(this.name);
		if (this.interfaceOperand != null) {
			writer.write(this.interfaceOperand);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GRAPH_ENTRY_POINT_ARM;
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
		if (!(o instanceof OpGraphEntryPointARM)) {
			return false;
		}
		OpGraphEntryPointARM other = (OpGraphEntryPointARM) o;
		if (!this.graph.equals(other.graph)) {
			return false;
		}
		if (!this.name.equals(other.name)) {
			return false;
		}
		return Arrays.equals(this.interfaceOperand, other.interfaceOperand);
	}

	@Override
	public int hashCode() {
		int result = this.graph.hashCode();
		result += 31 * result + this.name.hashCode();
		return 31 * result + Arrays.hashCode(this.interfaceOperand);
	}
}