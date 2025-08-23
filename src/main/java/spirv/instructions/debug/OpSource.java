package spirv.instructions.debug;

import java.util.Objects;
import spirv.enumerants.SourceLanguage;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;

public class OpSource implements DebugInstruction {
	public SourceLanguage sourceLanguage;
	public int version;
	public Instruction file;
	public String source;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.sourceLanguage = SourceLanguage.get(data[offset]);
		this.version = data[offset + 1];
		if (length - 2 <= 0) {
			return;
		}
		this.file = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.source = InstructionUtil.readString(data, offset + 3).getString();
	}

	@Override
	public int size() {
		int size = 2;
		size += this.file == null ? 0 : 1;
		size += this.source == null ? 0 : InstructionUtil.wordCount(this.source);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.sourceLanguage);
		writer.write(this.version);
		if (this.file != null) {
			writer.write(this.file);
		}
		if (this.source != null) {
			writer.write(this.source);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SOURCE;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSource)) {
			return false;
		}
		OpSource other = (OpSource) o;
		if (this.sourceLanguage != other.sourceLanguage) {
			return false;
		}
		if (this.version != other.version) {
			return false;
		}
		if (!Objects.equals(this.file, other.file)) {
			return false;
		}
		return Objects.equals(this.source, other.source);
	}

	@Override
	public int hashCode() {
		int result = this.sourceLanguage.hashCode();
		result += 31 * result + this.version;
		result += 31 * result + Objects.hashCode(this.file);
		return 31 * result + Objects.hashCode(this.source);
	}
}