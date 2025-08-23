package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;

public class OpTypeForwardPointer implements TypeDeclarationInstruction {
	public Instruction pointerType;
	public StorageClass storageClass;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointerType = instructions[data[offset]];
		this.storageClass = StorageClass.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointerType);
		writer.write(this.storageClass);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_FORWARD_POINTER;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Addresses", "PhysicalStorageBufferAddresses" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeForwardPointer)) {
			return false;
		}
		OpTypeForwardPointer other = (OpTypeForwardPointer) o;
		if (!this.pointerType.equals(other.pointerType)) {
			return false;
		}
		return this.storageClass != other.storageClass;
	}

	@Override
	public int hashCode() {
		int result = this.pointerType.hashCode();
		return 31 * result + this.storageClass.hashCode();
	}
}