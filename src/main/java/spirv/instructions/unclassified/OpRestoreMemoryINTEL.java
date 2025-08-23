package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpRestoreMemoryINTEL implements Instruction {
	public Instruction ptr;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.ptr = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.ptr);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RESTORE_MEMORY_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "VariableLengthArrayINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpRestoreMemoryINTEL)) {
			return false;
		}
		OpRestoreMemoryINTEL other = (OpRestoreMemoryINTEL) o;
		return this.ptr.equals(other.ptr);
	}

	@Override
	public int hashCode() {
		return this.ptr.hashCode();
	}
}