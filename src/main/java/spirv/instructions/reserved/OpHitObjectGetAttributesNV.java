package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectGetAttributesNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction hitObjectAttribute;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		this.hitObjectAttribute = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		writer.write(this.hitObjectAttribute);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_GET_ATTRIBUTES_NV;
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
		if (!(o instanceof OpHitObjectGetAttributesNV)) {
			return false;
		}
		OpHitObjectGetAttributesNV other = (OpHitObjectGetAttributesNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		return this.hitObjectAttribute.equals(other.hitObjectAttribute);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		return 31 * result + this.hitObjectAttribute.hashCode();
	}
}