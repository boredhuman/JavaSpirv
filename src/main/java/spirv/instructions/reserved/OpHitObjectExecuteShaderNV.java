package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectExecuteShaderNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		this.payload = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_EXECUTE_SHADER_NV;
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
		if (!(o instanceof OpHitObjectExecuteShaderNV)) {
			return false;
		}
		OpHitObjectExecuteShaderNV other = (OpHitObjectExecuteShaderNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}