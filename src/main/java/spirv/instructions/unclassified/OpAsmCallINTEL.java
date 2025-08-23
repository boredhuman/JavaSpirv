package spirv.instructions.unclassified;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpAsmCallINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction asm;
	public Instruction[] argument;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.asm = instructions[data[offset + 2]];
		this.argument = new Instruction[length - 3];
		for (int i = 0; i < this.argument.length; i++) {
			this.argument[i] = instructions[data[offset + 3 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.argument == null ? 0 : this.argument.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.asm);
		if (this.argument != null) {
			writer.write(this.argument);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ASM_CALL_INTEL;
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
		if (!(o instanceof OpAsmCallINTEL)) {
			return false;
		}
		OpAsmCallINTEL other = (OpAsmCallINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.asm.equals(other.asm)) {
			return false;
		}
		return Arrays.equals(this.argument, other.argument);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.asm.hashCode();
		return 31 * result + Arrays.hashCode(this.argument);
	}
}