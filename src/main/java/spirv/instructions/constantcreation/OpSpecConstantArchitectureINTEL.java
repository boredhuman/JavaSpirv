package spirv.instructions.constantcreation;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSpecConstantArchitectureINTEL implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public int category;
	public int family;
	public int opcode;
	public int architecture;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.category = data[offset + 2];
		this.family = data[offset + 3];
		this.opcode = data[offset + 4];
		this.architecture = data[offset + 5];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.category);
		writer.write(this.family);
		writer.write(this.opcode);
		writer.write(this.architecture);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SPEC_CONSTANT_ARCHITECTURE_INTEL;
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
		 return new String[] { "FunctionVariantsINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSpecConstantArchitectureINTEL)) {
			return false;
		}
		OpSpecConstantArchitectureINTEL other = (OpSpecConstantArchitectureINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.category != other.category) {
			return false;
		}
		if (this.family != other.family) {
			return false;
		}
		if (this.opcode != other.opcode) {
			return false;
		}
		return this.architecture != other.architecture;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.category;
		result += 31 * result + this.family;
		result += 31 * result + this.opcode;
		return 31 * result + this.architecture;
	}
}