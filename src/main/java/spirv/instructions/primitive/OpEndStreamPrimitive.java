package spirv.instructions.primitive;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpEndStreamPrimitive implements PrimitiveInstruction {
	public Instruction stream;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.stream = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.stream);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_END_STREAM_PRIMITIVE;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "GeometryStreams" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpEndStreamPrimitive)) {
			return false;
		}
		OpEndStreamPrimitive other = (OpEndStreamPrimitive) o;
		return this.stream.equals(other.stream);
	}

	@Override
	public int hashCode() {
		return this.stream.hashCode();
	}
}