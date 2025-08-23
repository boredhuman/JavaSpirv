package spirv.instructions.reserved;

import spirv.instructions.OpCodes;

public class OpEndInvocationInterlockEXT implements ReservedInstruction {

	@Override
	public int opcode() {
		return OpCodes.OP_END_INVOCATION_INTERLOCK_EXT;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "FragmentShaderSampleInterlockEXT", "FragmentShaderPixelInterlockEXT", "FragmentShaderShadingRateInterlockEXT" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_EXT_fragment_shader_interlock" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		 return o instanceof OpEndInvocationInterlockEXT;
	}

	@Override
	public int hashCode() {
		 return OpCodes.OP_END_INVOCATION_INTERLOCK_EXT;
	}
}