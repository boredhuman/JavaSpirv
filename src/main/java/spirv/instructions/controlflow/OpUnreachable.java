package spirv.instructions.controlflow;

import spirv.instructions.OpCodes;

public class OpUnreachable implements ControlFlowInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_UNREACHABLE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpUnreachable;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_UNREACHABLE;
	}
}