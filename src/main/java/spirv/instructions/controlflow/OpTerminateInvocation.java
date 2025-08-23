package spirv.instructions.controlflow;

import spirv.instructions.OpCodes;

public class OpTerminateInvocation implements ControlFlowInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_TERMINATE_INVOCATION;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Shader" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_terminate_invocation" };
	}

	@Override
	public String version() {
		return "1.6";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpTerminateInvocation;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_TERMINATE_INVOCATION;
	}
}