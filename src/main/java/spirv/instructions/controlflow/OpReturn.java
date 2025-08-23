package spirv.instructions.controlflow;

import spirv.instructions.OpCodes;

public class OpReturn implements ControlFlowInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_RETURN;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpReturn;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_RETURN;
	}
}