package spirv.instructions.function;

import spirv.instructions.OpCodes;

public class OpFunctionEnd implements FunctionInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_FUNCTION_END;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpFunctionEnd;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_FUNCTION_END;
	}
}