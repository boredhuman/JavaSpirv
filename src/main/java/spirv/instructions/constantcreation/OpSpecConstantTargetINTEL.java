package spirv.instructions.constantcreation;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSpecConstantTargetINTEL implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public int target;
	public int[] features;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.target = data[offset + 2];
		this.features = new int[length - 3];
		for (int i = 0; i < this.features.length; i++) {
			this.features[i] = data[offset + 3 + i];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.features == null ? 0 : this.features.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.target);
		if (this.features != null) {
			writer.write(this.features);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SPEC_CONSTANT_TARGET_INTEL;
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
		if (!(o instanceof OpSpecConstantTargetINTEL)) {
			return false;
		}
		OpSpecConstantTargetINTEL other = (OpSpecConstantTargetINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.target != other.target) {
			return false;
		}
		return Arrays.equals(this.features, other.features);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.target;
		return 31 * result + Arrays.hashCode(this.features);
	}
}