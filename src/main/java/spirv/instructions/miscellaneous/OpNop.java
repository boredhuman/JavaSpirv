package spirv.instructions.miscellaneous;

import spirv.instructions.OpCodes;

public class OpNop implements MiscellaneousInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_NOP;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpNop;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_NOP;
	}
}