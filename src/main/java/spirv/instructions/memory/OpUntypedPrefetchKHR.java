package spirv.instructions.memory;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpUntypedPrefetchKHR implements MemoryInstruction {
	public Instruction pointerType;
	public Instruction numBytes;
	public Instruction rw;
	public Instruction locality;
	public Instruction cacheType;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pointerType = instructions[data[offset]];
		this.numBytes = instructions[data[offset + 1]];
		if (length - 2 <= 0) {
			return;
		}
		this.rw = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.locality = instructions[data[offset + 3]];
		if (length - 4 <= 0) {
			return;
		}
		this.cacheType = instructions[data[offset + 4]];
	}

	@Override
	public int size() {
		int size = 2;
		size += this.rw == null ? 0 : 1;
		size += this.locality == null ? 0 : 1;
		size += this.cacheType == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pointerType);
		writer.write(this.numBytes);
		if (this.rw != null) {
			writer.write(this.rw);
		}
		if (this.locality != null) {
			writer.write(this.locality);
		}
		if (this.cacheType != null) {
			writer.write(this.cacheType);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_UNTYPED_PREFETCH_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "UntypedPointersKHR" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpUntypedPrefetchKHR)) {
			return false;
		}
		OpUntypedPrefetchKHR other = (OpUntypedPrefetchKHR) o;
		if (!this.pointerType.equals(other.pointerType)) {
			return false;
		}
		if (!this.numBytes.equals(other.numBytes)) {
			return false;
		}
		if (!Objects.equals(this.rw, other.rw)) {
			return false;
		}
		if (!Objects.equals(this.locality, other.locality)) {
			return false;
		}
		return Objects.equals(this.cacheType, other.cacheType);
	}

	@Override
	public int hashCode() {
		int result = this.pointerType.hashCode();
		result += 31 * result + this.numBytes.hashCode();
		result += 31 * result + Objects.hashCode(this.rw);
		result += 31 * result + Objects.hashCode(this.locality);
		return 31 * result + Objects.hashCode(this.cacheType);
	}
}