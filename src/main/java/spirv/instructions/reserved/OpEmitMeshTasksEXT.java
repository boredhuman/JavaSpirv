package spirv.instructions.reserved;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpEmitMeshTasksEXT implements ReservedInstruction {
	public Instruction groupCountX;
	public Instruction groupCountY;
	public Instruction groupCountZ;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.groupCountX = instructions[data[offset]];
		this.groupCountY = instructions[data[offset + 1]];
		this.groupCountZ = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.payload = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		int size = 3;
		size += this.payload == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.groupCountX);
		writer.write(this.groupCountY);
		writer.write(this.groupCountZ);
		if (this.payload != null) {
			writer.write(this.payload);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EMIT_MESH_TASKS_EXT;
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
		if (!(o instanceof OpEmitMeshTasksEXT)) {
			return false;
		}
		OpEmitMeshTasksEXT other = (OpEmitMeshTasksEXT) o;
		if (!this.groupCountX.equals(other.groupCountX)) {
			return false;
		}
		if (!this.groupCountY.equals(other.groupCountY)) {
			return false;
		}
		if (!this.groupCountZ.equals(other.groupCountZ)) {
			return false;
		}
		return Objects.equals(this.payload, other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.groupCountX.hashCode();
		result += 31 * result + this.groupCountY.hashCode();
		result += 31 * result + this.groupCountZ.hashCode();
		return 31 * result + Objects.hashCode(this.payload);
	}
}