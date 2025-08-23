package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcImeEvaluateWithDualReferenceStreaminINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction srcImage;
	public Instruction fwdRefImage;
	public Instruction bwdRefImage;
	public Instruction payload;
	public Instruction streaminComponents;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.srcImage = instructions[data[offset + 2]];
		this.fwdRefImage = instructions[data[offset + 3]];
		this.bwdRefImage = instructions[data[offset + 4]];
		this.payload = instructions[data[offset + 5]];
		this.streaminComponents = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.srcImage);
		writer.write(this.fwdRefImage);
		writer.write(this.bwdRefImage);
		writer.write(this.payload);
		writer.write(this.streaminComponents);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_IME_EVALUATE_WITH_DUAL_REFERENCE_STREAMIN_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcImeEvaluateWithDualReferenceStreaminINTEL)) {
			return false;
		}
		OpSubgroupAvcImeEvaluateWithDualReferenceStreaminINTEL other = (OpSubgroupAvcImeEvaluateWithDualReferenceStreaminINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.srcImage.equals(other.srcImage)) {
			return false;
		}
		if (!this.fwdRefImage.equals(other.fwdRefImage)) {
			return false;
		}
		if (!this.bwdRefImage.equals(other.bwdRefImage)) {
			return false;
		}
		if (!this.payload.equals(other.payload)) {
			return false;
		}
		return this.streaminComponents.equals(other.streaminComponents);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.srcImage.hashCode();
		result += 31 * result + this.fwdRefImage.hashCode();
		result += 31 * result + this.bwdRefImage.hashCode();
		result += 31 * result + this.payload.hashCode();
		return 31 * result + this.streaminComponents.hashCode();
	}
}