package spirv.instructions.typedeclaration;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpTypeStructContinuedINTEL implements TypeDeclarationInstruction {
	public Instruction[] member0Type;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.member0Type = new Instruction[length];
		for (int i = 0; i < this.member0Type.length; i++) {
			this.member0Type[i] = instructions[data[offset + i]];
		}
	}

	@Override
	public int size() {
		int size = 0;
		size += this.member0Type == null ? 0 : this.member0Type.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		if (this.member0Type != null) {
			writer.write(this.member0Type);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_STRUCT_CONTINUED_INTEL;
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
		if (!(o instanceof OpTypeStructContinuedINTEL)) {
			return false;
		}
		OpTypeStructContinuedINTEL other = (OpTypeStructContinuedINTEL) o;
		return Arrays.equals(this.member0Type, other.member0Type);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(this.member0Type);
	}
}