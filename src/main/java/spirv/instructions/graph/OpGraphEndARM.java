package spirv.instructions.graph;

import spirv.instructions.OpCodes;

public class OpGraphEndARM implements GraphInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_GRAPH_END_ARM;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "GraphARM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpGraphEndARM;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_GRAPH_END_ARM;
	}
}