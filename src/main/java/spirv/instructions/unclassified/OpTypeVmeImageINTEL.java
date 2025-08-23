package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeVmeImageINTEL implements Instruction, Result {
	public int idResult;
	public Instruction imageType;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.imageType = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.imageType);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_VME_IMAGE_INTEL;
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
		if (!(o instanceof OpTypeVmeImageINTEL)) {
			return false;
		}
		OpTypeVmeImageINTEL other = (OpTypeVmeImageINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.imageType.equals(other.imageType);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.imageType.hashCode();
	}
}