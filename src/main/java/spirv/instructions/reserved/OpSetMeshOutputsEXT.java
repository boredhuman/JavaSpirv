package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpSetMeshOutputsEXT implements ReservedInstruction {
	public Instruction vertexCount;
	public Instruction primitiveCount;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.vertexCount = instructions[data[offset]];
		this.primitiveCount = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.vertexCount);
		writer.write(this.primitiveCount);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SET_MESH_OUTPUTS_EXT;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "MeshShadingEXT" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSetMeshOutputsEXT)) {
			return false;
		}
		OpSetMeshOutputsEXT other = (OpSetMeshOutputsEXT) o;
		if (!this.vertexCount.equals(other.vertexCount)) {
			return false;
		}
		return this.primitiveCount.equals(other.primitiveCount);
	}

	@Override
	public int hashCode() {
		int result = this.vertexCount.hashCode();
		return 31 * result + this.primitiveCount.hashCode();
	}
}