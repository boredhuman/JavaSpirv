package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpWritePackedPrimitiveIndices4x8NV implements ReservedInstruction {
	public Instruction indexOffset;
	public Instruction packedIndices;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.indexOffset = instructions[data[offset]];
		this.packedIndices = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.indexOffset);
		writer.write(this.packedIndices);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_WRITE_PACKED_PRIMITIVE_INDICES4X8NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "MeshShadingNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_mesh_shader" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpWritePackedPrimitiveIndices4x8NV)) {
			return false;
		}
		OpWritePackedPrimitiveIndices4x8NV other = (OpWritePackedPrimitiveIndices4x8NV) o;
		if (!this.indexOffset.equals(other.indexOffset)) {
			return false;
		}
		return this.packedIndices.equals(other.packedIndices);
	}

	@Override
	public int hashCode() {
		int result = this.indexOffset.hashCode();
		return 31 * result + this.packedIndices.hashCode();
	}
}