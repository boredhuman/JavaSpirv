package spirv.instructions.pipe;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpCommitWritePipe implements PipeInstruction {
	public Instruction pipe;
	public Instruction reserveId;
	public Instruction packetSize;
	public Instruction packetAlignment;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.pipe = instructions[data[offset]];
		this.reserveId = instructions[data[offset + 1]];
		this.packetSize = instructions[data[offset + 2]];
		this.packetAlignment = instructions[data[offset + 3]];
	}

	@Override
	public int size() {
		return 4;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.pipe);
		writer.write(this.reserveId);
		writer.write(this.packetSize);
		writer.write(this.packetAlignment);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_COMMIT_WRITE_PIPE;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "Pipes" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpCommitWritePipe)) {
			return false;
		}
		OpCommitWritePipe other = (OpCommitWritePipe) o;
		if (!this.pipe.equals(other.pipe)) {
			return false;
		}
		if (!this.reserveId.equals(other.reserveId)) {
			return false;
		}
		if (!this.packetSize.equals(other.packetSize)) {
			return false;
		}
		return this.packetAlignment.equals(other.packetAlignment);
	}

	@Override
	public int hashCode() {
		int result = this.pipe.hashCode();
		result += 31 * result + this.reserveId.hashCode();
		result += 31 * result + this.packetSize.hashCode();
		return 31 * result + this.packetAlignment.hashCode();
	}
}