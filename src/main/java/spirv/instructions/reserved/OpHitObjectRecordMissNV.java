package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectRecordMissNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction sbtIndex;
	public Instruction origin;
	public Instruction tMin;
	public Instruction direction;
	public Instruction tMax;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		this.sbtIndex = instructions[data[offset + 1]];
		this.origin = instructions[data[offset + 2]];
		this.tMin = instructions[data[offset + 3]];
		this.direction = instructions[data[offset + 4]];
		this.tMax = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		writer.write(this.sbtIndex);
		writer.write(this.origin);
		writer.write(this.tMin);
		writer.write(this.direction);
		writer.write(this.tMax);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_RECORD_MISS_NV;
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
		if (!(o instanceof OpHitObjectRecordMissNV)) {
			return false;
		}
		OpHitObjectRecordMissNV other = (OpHitObjectRecordMissNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		if (!this.sbtIndex.equals(other.sbtIndex)) {
			return false;
		}
		if (!this.origin.equals(other.origin)) {
			return false;
		}
		if (!this.tMin.equals(other.tMin)) {
			return false;
		}
		if (!this.direction.equals(other.direction)) {
			return false;
		}
		return this.tMax.equals(other.tMax);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		result += 31 * result + this.sbtIndex.hashCode();
		result += 31 * result + this.origin.hashCode();
		result += 31 * result + this.tMin.hashCode();
		result += 31 * result + this.direction.hashCode();
		return 31 * result + this.tMax.hashCode();
	}
}