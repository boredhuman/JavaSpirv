package spirv.instructions.typedeclaration;

import java.util.Objects;
import spirv.enumerants.AccessQualifier;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.ImageFormat;
import spirv.enumerants.Dim;
import spirv.instructions.Result;

public class OpTypeImage implements TypeDeclarationInstruction, Result {
	public int idResult;
	public Instruction sampledType;
	public Dim dim;
	public int depth;
	public int arrayed;
	public int ms;
	public int sampled;
	public ImageFormat imageFormat;
	public AccessQualifier accessQualifier;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.sampledType = instructions[data[offset + 1]];
		this.dim = Dim.get(data[offset + 2]);
		this.depth = data[offset + 3];
		this.arrayed = data[offset + 4];
		this.ms = data[offset + 5];
		this.sampled = data[offset + 6];
		this.imageFormat = ImageFormat.get(data[offset + 7]);
		if (length - 8 <= 0) {
			return;
		}
		this.accessQualifier = AccessQualifier.get(data[offset + 8]);
	}

	@Override
	public int size() {
		int size = 8;
		size += this.accessQualifier == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.sampledType);
		writer.write(this.dim);
		writer.write(this.depth);
		writer.write(this.arrayed);
		writer.write(this.ms);
		writer.write(this.sampled);
		writer.write(this.imageFormat);
		if (this.accessQualifier != null) {
			writer.write(this.accessQualifier);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_IMAGE;
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
		if (!(o instanceof OpTypeImage)) {
			return false;
		}
		OpTypeImage other = (OpTypeImage) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.sampledType.equals(other.sampledType)) {
			return false;
		}
		if (this.dim != other.dim) {
			return false;
		}
		if (this.depth != other.depth) {
			return false;
		}
		if (this.arrayed != other.arrayed) {
			return false;
		}
		if (this.ms != other.ms) {
			return false;
		}
		if (this.sampled != other.sampled) {
			return false;
		}
		if (this.imageFormat != other.imageFormat) {
			return false;
		}
		return Objects.equals(this.accessQualifier, other.accessQualifier);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.sampledType.hashCode();
		result += 31 * result + this.dim.hashCode();
		result += 31 * result + this.depth;
		result += 31 * result + this.arrayed;
		result += 31 * result + this.ms;
		result += 31 * result + this.sampled;
		result += 31 * result + this.imageFormat.hashCode();
		return 31 * result + Objects.hashCode(this.accessQualifier);
	}
}