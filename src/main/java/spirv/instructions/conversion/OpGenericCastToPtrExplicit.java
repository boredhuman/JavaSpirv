package spirv.instructions.conversion;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.StorageClass;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpGenericCastToPtrExplicit implements ConversionInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pointer;
	public StorageClass storage;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pointer = instructions[data[offset + 2]];
		this.storage = StorageClass.get(data[offset + 3]);
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pointer);
		writer.write(this.storage);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_GENERIC_CAST_TO_PTR_EXPLICIT;
	}

	@Override
	public Instruction resultType() {
		return this.idResultType;
	}

	@Override
	public void setResultType(Instruction resultType) {
		this.idResultType = resultType;
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
		 return new String[] { "Kernel" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpGenericCastToPtrExplicit)) {
			return false;
		}
		OpGenericCastToPtrExplicit other = (OpGenericCastToPtrExplicit) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		return this.storage != other.storage;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pointer.hashCode();
		return 31 * result + this.storage.hashCode();
	}
}