package spirv.instructions.composite;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpExtractSubArrayQCOM implements CompositeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sourceArray;
	public Instruction index;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sourceArray = instructions[data[offset + 2]];
		this.index = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.sourceArray);
		writer.write(this.index);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXTRACT_SUB_ARRAY_QCOM;
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
		 return new String[] { "CooperativeMatrixConversionQCOM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExtractSubArrayQCOM)) {
			return false;
		}
		OpExtractSubArrayQCOM other = (OpExtractSubArrayQCOM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.sourceArray.equals(other.sourceArray)) {
			return false;
		}
		return this.index.equals(other.index);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.sourceArray.hashCode();
		return 31 * result + this.index.hashCode();
	}
}