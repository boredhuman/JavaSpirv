package spirv.instructions.composite;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCompositeConstructCoopMatQCOM implements CompositeInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction sourceArray;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.sourceArray = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.sourceArray);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COMPOSITE_CONSTRUCT_COOP_MAT_QCOM;
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
		if (!(o instanceof OpCompositeConstructCoopMatQCOM)) {
			return false;
		}
		OpCompositeConstructCoopMatQCOM other = (OpCompositeConstructCoopMatQCOM) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.sourceArray.equals(other.sourceArray);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + this.sourceArray.hashCode();
	}
}