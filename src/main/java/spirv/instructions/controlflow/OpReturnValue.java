package spirv.instructions.controlflow;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpReturnValue implements ControlFlowInstruction {
	public Instruction value;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.value = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.value);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RETURN_VALUE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpReturnValue)) {
			return false;
		}
		OpReturnValue other = (OpReturnValue) o;
		return this.value.equals(other.value);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
}