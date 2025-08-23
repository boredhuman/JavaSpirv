package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.Result;

public class OpAsmTargetINTEL implements Instruction, Result {
	public int idResult;
	public String asmTarget;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.asmTarget = InstructionUtil.readString(data, offset + 1).getString();
	}

	@Override
	public int size() {
		int size = 1;
		size += InstructionUtil.wordCount(this.asmTarget);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.asmTarget);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ASM_TARGET_INTEL;
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
		 return new String[] { "AsmINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAsmTargetINTEL)) {
			return false;
		}
		OpAsmTargetINTEL other = (OpAsmTargetINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.asmTarget.equals(other.asmTarget);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.asmTarget.hashCode();
	}
}