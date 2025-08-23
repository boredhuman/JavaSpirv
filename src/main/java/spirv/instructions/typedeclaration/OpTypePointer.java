package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;
import spirv.instructions.Result;

public class OpTypePointer implements TypeDeclarationInstruction, Result {
	public int idResult;
	public StorageClass storageClass;
	public Instruction type;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.storageClass = StorageClass.get(data[offset + 1]);
		this.type = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.storageClass);
		writer.write(this.type);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_POINTER;
	}

	@Override
	public int result() {
		return this.idResult;
	}

	@Override
	public void setResult(int result) {
		this.idResult = result;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypePointer)) {
			return false;
		}
		OpTypePointer other = (OpTypePointer) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.storageClass != other.storageClass) {
			return false;
		}
		return this.type.equals(other.type);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.storageClass.hashCode();
		return 31 * result + this.type.hashCode();
	}
}