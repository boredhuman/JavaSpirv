package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeCooperativeVectorNV implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction componentType;
	public Instruction componentCount;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.componentType = instructions[data[offset + 1]];
		this.componentCount = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.componentType);
		writer.write(this.componentCount);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_COOPERATIVE_VECTOR_NV;
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
		 return new String[] { "CooperativeVectorNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeCooperativeVectorNV)) {
			return false;
		}
		OpTypeCooperativeVectorNV other = (OpTypeCooperativeVectorNV) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.componentType.equals(other.componentType)) {
			return false;
		}
		return this.componentCount.equals(other.componentCount);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.componentType.hashCode();
		return 31 * result + this.componentCount.hashCode();
	}
}