package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectRecordEmptyNV implements ReservedInstruction {
	public Instruction hitObject;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_RECORD_EMPTY_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "ShaderInvocationReorderNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpHitObjectRecordEmptyNV)) {
			return false;
		}
		OpHitObjectRecordEmptyNV other = (OpHitObjectRecordEmptyNV) o;
		return this.hitObject.equals(other.hitObject);
	}

	@Override
	public int hashCode() {
		return this.hitObject.hashCode();
	}
}