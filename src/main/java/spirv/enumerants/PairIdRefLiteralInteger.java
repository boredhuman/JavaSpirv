package spirv.enumerants;

import spirv.instructions.InstructionWriter;
import spirv.instructions.Instruction;

public class PairIdRefLiteralInteger {
	public Instruction value0;
	public int value1;

	public PairIdRefLiteralInteger(Instruction value0, int value1) {
		this.value0 = value0;
		this.value1 = value1;
	}

	public void write(InstructionWriter writer) {
		writer.write(this.value0);
		writer.write(this.value1);
	}
}