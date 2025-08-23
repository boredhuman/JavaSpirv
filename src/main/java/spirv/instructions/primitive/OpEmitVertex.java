package spirv.instructions.primitive;

import spirv.instructions.OpCodes;

public class OpEmitVertex implements PrimitiveInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_EMIT_VERTEX;
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
		 return o instanceof OpEmitVertex;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_EMIT_VERTEX;
	}
}