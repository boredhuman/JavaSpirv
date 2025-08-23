package spirv.instructions.debug;

import spirv.instructions.OpCodes;

public class OpNoLine implements DebugInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_NO_LINE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpNoLine;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_NO_LINE;
	}
}