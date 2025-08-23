package spirv.instructions.controlflow;

import spirv.instructions.OpCodes;

public class OpKill implements ControlFlowInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_KILL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Shader" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpKill;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_KILL;
	}
}