package spirv.instructions.constantcreation;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.LiteralSpecConstantOpInteger;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSpecConstantOp implements ConstantCreationInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public LiteralSpecConstantOpInteger opcode;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.opcode = new LiteralSpecConstantOpInteger(data, offset, length, instructions);
	}

	@Override
	public int size() {
		int size = 2;
		size += this.opcode.size();
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		this.opcode.write(writer);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SPEC_CONSTANT_OP;
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
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSpecConstantOp)) {
			return false;
		}
		OpSpecConstantOp other = (OpSpecConstantOp) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.opcode.equals(other.opcode);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + this.opcode.hashCode();
	}
}