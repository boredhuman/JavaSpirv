package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;
import spirv.instructions.Result;

public class OpTypeUntypedPointerKHR implements TypeDeclarationInstruction, Result {
	public int idResult;
	public StorageClass storageClass;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.storageClass = StorageClass.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.storageClass);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_UNTYPED_POINTER_KHR;
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
	public String[] capabilities() {
		 return new String[] { "UntypedPointersKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeUntypedPointerKHR)) {
			return false;
		}
		OpTypeUntypedPointerKHR other = (OpTypeUntypedPointerKHR) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.storageClass != other.storageClass;
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.storageClass.hashCode();
	}
}