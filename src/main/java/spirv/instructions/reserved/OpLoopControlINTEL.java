package spirv.instructions.reserved;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpLoopControlINTEL implements ReservedInstruction {
	public int[] loopControlParameters;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.loopControlParameters = new int[length];
		for (int i = 0; i < this.loopControlParameters.length; i++) {
			this.loopControlParameters[i] = data[offset + i];
		}
	}

	@Override
	public int size() {
		int size = 0;
		size += this.loopControlParameters == null ? 0 : this.loopControlParameters.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		if (this.loopControlParameters != null) {
			writer.write(this.loopControlParameters);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_LOOP_CONTROL_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "UnstructuredLoopControlsINTEL" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_INTEL_unstructured_loop_controls" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpLoopControlINTEL)) {
			return false;
		}
		OpLoopControlINTEL other = (OpLoopControlINTEL) o;
		return Arrays.equals(this.loopControlParameters, other.loopControlParameters);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(this.loopControlParameters);
	}
}