package spirv.instructions.constantcreation;

import spirv.enumerants.Capability;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSpecConstantCapabilitiesINTEL implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Capability[] capabilities;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.capabilities = new Capability[length - 2];
		for (int i = 0; i < this.capabilities.length; i++) {
			this.capabilities[i] = Capability.get(data[offset + 2 + i]);
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.capabilities == null ? 0 : this.capabilities.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		if (this.capabilities != null) {
			writer.write(this.capabilities);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SPEC_CONSTANT_CAPABILITIES_INTEL;
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
		if (!(o instanceof OpSpecConstantCapabilitiesINTEL)) {
			return false;
		}
		OpSpecConstantCapabilitiesINTEL other = (OpSpecConstantCapabilitiesINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.capabilities, other.capabilities);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + Arrays.hashCode(this.capabilities);
	}
}