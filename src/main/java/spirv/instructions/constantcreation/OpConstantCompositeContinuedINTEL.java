package spirv.instructions.constantcreation;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpConstantCompositeContinuedINTEL implements ConstantCreationInstruction {
	public Instruction[] constituents;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.constituents = new Instruction[length];
		for (int i = 0; i < this.constituents.length; i++) {
			this.constituents[i] = instructions[data[offset + i]];
		}
	}

	@Override
	public int size() {
		int size = 0;
		size += this.constituents == null ? 0 : this.constituents.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		if (this.constituents != null) {
			writer.write(this.constituents);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONSTANT_COMPOSITE_CONTINUED_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "LongCompositesINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConstantCompositeContinuedINTEL)) {
			return false;
		}
		OpConstantCompositeContinuedINTEL other = (OpConstantCompositeContinuedINTEL) o;
		return Arrays.equals(this.constituents, other.constituents);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(this.constituents);
	}
}