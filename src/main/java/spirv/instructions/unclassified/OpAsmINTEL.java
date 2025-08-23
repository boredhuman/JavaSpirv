package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpAsmINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction asmType;
	public Instruction target;
	public String asmInstructions;
	public String constraints;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.asmType = instructions[data[offset + 2]];
		this.target = instructions[data[offset + 3]];
		this.asmInstructions = InstructionUtil.readString(data, offset + 4).getString();
		int dynamicOffset = InstructionUtil.wordCount(this.asmInstructions) + 4;
		this.constraints = InstructionUtil.readString(data, offset + dynamicOffset).getString();
	}

	@Override
	public int size() {
		int size = 4;
		size += InstructionUtil.wordCount(this.asmInstructions);
		size += InstructionUtil.wordCount(this.constraints);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.asmType);
		writer.write(this.target);
		writer.write(this.asmInstructions);
		writer.write(this.constraints);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ASM_INTEL;
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
		 return new String[] { "AsmINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAsmINTEL)) {
			return false;
		}
		OpAsmINTEL other = (OpAsmINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.asmType.equals(other.asmType)) {
			return false;
		}
		if (!this.target.equals(other.target)) {
			return false;
		}
		if (!this.asmInstructions.equals(other.asmInstructions)) {
			return false;
		}
		return this.constraints.equals(other.constraints);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.asmType.hashCode();
		result += 31 * result + this.target.hashCode();
		result += 31 * result + this.asmInstructions.hashCode();
		return 31 * result + this.constraints.hashCode();
	}
}