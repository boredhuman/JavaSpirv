package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.BitMask;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.enumerants.RawAccessChainOperands;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpRawAccessChainNV implements MemoryInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction base;
	public Instruction byteStride;
	public Instruction elementIndex;
	public Instruction byteOffset;
	@BitMask(RawAccessChainOperands.class)
	public int rawAccessChainOperands;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.base = instructions[data[offset + 2]];
		this.byteStride = instructions[data[offset + 3]];
		this.elementIndex = instructions[data[offset + 4]];
		this.byteOffset = instructions[data[offset + 5]];
		if (length - 6 <= 0) {
			return;
		}
		this.rawAccessChainOperands = data[offset + 6];
	}

	@Override
	public int size() {
		int size = 6;
		size += this.rawAccessChainOperands == 0 ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.base);
		writer.write(this.byteStride);
		writer.write(this.elementIndex);
		writer.write(this.byteOffset);
		if (this.rawAccessChainOperands > 0) {
			writer.write(this.rawAccessChainOperands);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_RAW_ACCESS_CHAIN_NV;
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
		 return new String[] { "RawAccessChainsNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpRawAccessChainNV)) {
			return false;
		}
		OpRawAccessChainNV other = (OpRawAccessChainNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.base.equals(other.base)) {
			return false;
		}
		if (!this.byteStride.equals(other.byteStride)) {
			return false;
		}
		if (!this.elementIndex.equals(other.elementIndex)) {
			return false;
		}
		if (!this.byteOffset.equals(other.byteOffset)) {
			return false;
		}
		return Objects.equals(this.rawAccessChainOperands, other.rawAccessChainOperands);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.base.hashCode();
		result += 31 * result + this.byteStride.hashCode();
		result += 31 * result + this.elementIndex.hashCode();
		result += 31 * result + this.byteOffset.hashCode();
		return 31 * result + Objects.hashCode(this.rawAccessChainOperands);
	}
}