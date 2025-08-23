package spirv.instructions.controlflow;

import spirv.instructions.OpCodes;

public class OpDemoteToHelperInvocation implements ControlFlowInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_DEMOTE_TO_HELPER_INVOCATION;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "DemoteToHelperInvocation" };
	}

	@Override
	public String version() {
		return "1.6";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpDemoteToHelperInvocation;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_DEMOTE_TO_HELPER_INVOCATION;
	}
}