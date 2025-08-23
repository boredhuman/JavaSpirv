package spirv.instructions.constantcreation;

import spirv.enumerants.SamplerAddressingMode;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.enumerants.SamplerFilterMode;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpConstantSampler implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public SamplerAddressingMode samplerAddressingMode;
	public int param;
	public SamplerFilterMode samplerFilterMode;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.samplerAddressingMode = SamplerAddressingMode.get(data[offset + 2]);
		this.param = data[offset + 3];
		this.samplerFilterMode = SamplerFilterMode.get(data[offset + 4]);
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.samplerAddressingMode);
		writer.write(this.param);
		writer.write(this.samplerFilterMode);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONSTANT_SAMPLER;
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
		 return new String[] { "LiteralSampler" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConstantSampler)) {
			return false;
		}
		OpConstantSampler other = (OpConstantSampler) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (this.samplerAddressingMode != other.samplerAddressingMode) {
			return false;
		}
		if (this.param != other.param) {
			return false;
		}
		return this.samplerFilterMode != other.samplerFilterMode;
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.samplerAddressingMode.hashCode();
		result += 31 * result + this.param;
		return 31 * result + this.samplerFilterMode.hashCode();
	}
}