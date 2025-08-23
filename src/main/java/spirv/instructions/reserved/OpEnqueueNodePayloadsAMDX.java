package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpEnqueueNodePayloadsAMDX implements ReservedInstruction {
	public Instruction payloadArray;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.payloadArray = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.payloadArray);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ENQUEUE_NODE_PAYLOADS_AMDX;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "ShaderEnqueueAMDX" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpEnqueueNodePayloadsAMDX)) {
			return false;
		}
		OpEnqueueNodePayloadsAMDX other = (OpEnqueueNodePayloadsAMDX) o;
		return this.payloadArray.equals(other.payloadArray);
	}

	@Override
	public int hashCode() {
		return this.payloadArray.hashCode();
	}
}