package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpFragmentFetchAMD implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction image;
	public Instruction coordinate;
	public Instruction fragmentIndex;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.image = instructions[data[offset + 2]];
		this.coordinate = instructions[data[offset + 3]];
		this.fragmentIndex = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		return 5;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.image);
		writer.write(this.coordinate);
		writer.write(this.fragmentIndex);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_FRAGMENT_FETCH_AMD;
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
		 return new String[] { "FragmentMaskAMD" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_AMD_shader_fragment_mask" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpFragmentFetchAMD)) {
			return false;
		}
		OpFragmentFetchAMD other = (OpFragmentFetchAMD) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.image.equals(other.image)) {
			return false;
		}
		if (!this.coordinate.equals(other.coordinate)) {
			return false;
		}
		return this.fragmentIndex.equals(other.fragmentIndex);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.image.hashCode();
		result += 31 * result + this.coordinate.hashCode();
		return 31 * result + this.fragmentIndex.hashCode();
	}
}