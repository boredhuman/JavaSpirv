package spirv.instructions.primitive;

import spirv.instructions.OpCodes;

public class OpEndPrimitive implements PrimitiveInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_END_PRIMITIVE;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Geometry" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpEndPrimitive;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_END_PRIMITIVE;
	}
}