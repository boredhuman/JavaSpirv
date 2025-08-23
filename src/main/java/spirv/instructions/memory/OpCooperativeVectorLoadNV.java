package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.MemoryAccess;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpCooperativeVectorLoadNV implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction pointer;
	public Instruction offset;
	@BitMask(MemoryAccess.class)
	public int memoryAccess;
	public Object[] memoryAccessArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.pointer = instructions[data[offset + 2]];
		this.offset = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.memoryAccess = data[offset + 4];
		this.memoryAccessArg = MemoryAccess.loadArg(this.memoryAccess, data, offset + 5, instructions);
	}

	@Override
	public int size() {
		int size = 4;
		size += this.memoryAccess == 0 ? 0 : 1;
		size += MemoryAccess.getArgumentCount(this.memoryAccess);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.pointer);
		writer.write(this.offset);
		if (this.memoryAccess > 0) {
			writer.write(this.memoryAccess);
			writer.write(this.memoryAccessArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COOPERATIVE_VECTOR_LOAD_NV;
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
		 return new String[] { "CooperativeVectorNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCooperativeVectorLoadNV)) {
			return false;
		}
		OpCooperativeVectorLoadNV other = (OpCooperativeVectorLoadNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.pointer.equals(other.pointer)) {
			return false;
		}
		if (!this.offset.equals(other.offset)) {
			return false;
		}
		if (!Objects.equals(this.memoryAccess, other.memoryAccess)) {
			return false;
		}
		return Arrays.equals(this.memoryAccessArg, other.memoryAccessArg);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.pointer.hashCode();
		result += 31 * result + this.offset.hashCode();
		result += 31 * result + Objects.hashCode(this.memoryAccess);
		return 31 * result + Arrays.hashCode(this.memoryAccessArg);
	}
}