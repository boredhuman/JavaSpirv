package spirv.instructions.extension;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpConditionalExtensionINTEL implements ExtensionInstruction {
	public Instruction condition;
	public String name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.condition = instructions[data[offset]];
		this.name = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.name);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.condition);
		writer.write(this.name);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONDITIONAL_EXTENSION_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SpecConditionalINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConditionalExtensionINTEL)) {
			return false;
		}
		OpConditionalExtensionINTEL other = (OpConditionalExtensionINTEL) o;
		if (!this.condition.equals(other.condition)) {
			return false;
		}
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		int result = this.condition.hashCode();
		return 31 * result + this.name.hashCode();
	}
}