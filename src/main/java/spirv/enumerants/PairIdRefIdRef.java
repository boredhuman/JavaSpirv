package spirv.enumerants;

import spirv.instructions.InstructionWriter;
import spirv.instructions.Instruction;

public class PairIdRefIdRef {
	public Instruction value0;
	public Instruction value1;

	public PairIdRefIdRef(Instruction value0, Instruction value1) {
		this.value0 = value0;
		this.value1 = value1;
	}

	public void write(InstructionWriter writer) {
		writer.write(this.value0);
		writer.write(this.value1);
	}
}