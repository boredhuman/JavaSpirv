package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpTensorViewSetClipNV implements ReservedInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction tensorView;
	public Instruction clipRowOffset;
	public Instruction clipRowSpan;
	public Instruction clipColOffset;
	public Instruction clipColSpan;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.tensorView = instructions[data[offset + 2]];
		this.clipRowOffset = instructions[data[offset + 3]];
		this.clipRowSpan = instructions[data[offset + 4]];
		this.clipColOffset = instructions[data[offset + 5]];
		this.clipColSpan = instructions[data[offset + 6]];
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.tensorView);
		writer.write(this.clipRowOffset);
		writer.write(this.clipRowSpan);
		writer.write(this.clipColOffset);
		writer.write(this.clipColSpan);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_VIEW_SET_CLIP_NV;
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
		 return new String[] { "TensorAddressingNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTensorViewSetClipNV)) {
			return false;
		}
		OpTensorViewSetClipNV other = (OpTensorViewSetClipNV) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.tensorView.equals(other.tensorView)) {
			return false;
		}
		if (!this.clipRowOffset.equals(other.clipRowOffset)) {
			return false;
		}
		if (!this.clipRowSpan.equals(other.clipRowSpan)) {
			return false;
		}
		if (!this.clipColOffset.equals(other.clipColOffset)) {
			return false;
		}
		return this.clipColSpan.equals(other.clipColSpan);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.tensorView.hashCode();
		result += 31 * result + this.clipRowOffset.hashCode();
		result += 31 * result + this.clipRowSpan.hashCode();
		result += 31 * result + this.clipColOffset.hashCode();
		return 31 * result + this.clipColSpan.hashCode();
	}
}