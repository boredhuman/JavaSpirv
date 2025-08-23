package spirv.instructions.image;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpColorAttachmentReadEXT implements ImageInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction attachment;
	public Instruction sample;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.attachment = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.sample = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		int size = 3;
		size += this.sample == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.attachment);
		if (this.sample != null) {
			writer.write(this.sample);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COLOR_ATTACHMENT_READ_EXT;
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
		 return new String[] { "TileImageColorReadAccessEXT" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpColorAttachmentReadEXT)) {
			return false;
		}
		OpColorAttachmentReadEXT other = (OpColorAttachmentReadEXT) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.attachment.equals(other.attachment)) {
			return false;
		}
		return Objects.equals(this.sample, other.sample);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.attachment.hashCode();
		return 31 * result + Objects.hashCode(this.sample);
	}
}