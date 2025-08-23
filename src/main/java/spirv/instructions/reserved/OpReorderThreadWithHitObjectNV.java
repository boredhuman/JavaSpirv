package spirv.instructions.reserved;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpReorderThreadWithHitObjectNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction hint;
	public Instruction bits;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		if (length - 1 <= 0) {
			return;
		}
		this.hint = instructions[data[offset + 1]];
		if (length - 2 <= 0) {
			return;
		}
		this.bits = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		int size = 1;
		size += this.hint == null ? 0 : 1;
		size += this.bits == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		if (this.hint != null) {
			writer.write(this.hint);
		}
		if (this.bits != null) {
			writer.write(this.bits);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_REORDER_THREAD_WITH_HIT_OBJECT_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "ShaderInvocationReorderNV" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpReorderThreadWithHitObjectNV)) {
			return false;
		}
		OpReorderThreadWithHitObjectNV other = (OpReorderThreadWithHitObjectNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		if (!Objects.equals(this.hint, other.hint)) {
			return false;
		}
		return Objects.equals(this.bits, other.bits);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		result += 31 * result + Objects.hashCode(this.hint);
		return 31 * result + Objects.hashCode(this.bits);
	}
}