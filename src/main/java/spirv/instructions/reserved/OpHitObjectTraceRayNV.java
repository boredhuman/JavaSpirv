package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectTraceRayNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction accelerationStructure;
	public Instruction rayFlags;
	public Instruction cullmask;
	public Instruction sbtRecordOffset;
	public Instruction sbtRecordStride;
	public Instruction missIndex;
	public Instruction origin;
	public Instruction tMin;
	public Instruction direction;
	public Instruction tMax;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		this.accelerationStructure = instructions[data[offset + 1]];
		this.rayFlags = instructions[data[offset + 2]];
		this.cullmask = instructions[data[offset + 3]];
		this.sbtRecordOffset = instructions[data[offset + 4]];
		this.sbtRecordStride = instructions[data[offset + 5]];
		this.missIndex = instructions[data[offset + 6]];
		this.origin = instructions[data[offset + 7]];
		this.tMin = instructions[data[offset + 8]];
		this.direction = instructions[data[offset + 9]];
		this.tMax = instructions[data[offset + 10]];
		this.payload = instructions[data[offset + 11]];
	}

	@Override
	public int size() {
		return 12;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		writer.write(this.accelerationStructure);
		writer.write(this.rayFlags);
		writer.write(this.cullmask);
		writer.write(this.sbtRecordOffset);
		writer.write(this.sbtRecordStride);
		writer.write(this.missIndex);
		writer.write(this.origin);
		writer.write(this.tMin);
		writer.write(this.direction);
		writer.write(this.tMax);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_TRACE_RAY_NV;
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
		if (!(o instanceof OpHitObjectTraceRayNV)) {
			return false;
		}
		OpHitObjectTraceRayNV other = (OpHitObjectTraceRayNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		if (!this.accelerationStructure.equals(other.accelerationStructure)) {
			return false;
		}
		if (!this.rayFlags.equals(other.rayFlags)) {
			return false;
		}
		if (!this.cullmask.equals(other.cullmask)) {
			return false;
		}
		if (!this.sbtRecordOffset.equals(other.sbtRecordOffset)) {
			return false;
		}
		if (!this.sbtRecordStride.equals(other.sbtRecordStride)) {
			return false;
		}
		if (!this.missIndex.equals(other.missIndex)) {
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
		if (!this.tMax.equals(other.tMax)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		result += 31 * result + this.accelerationStructure.hashCode();
		result += 31 * result + this.rayFlags.hashCode();
		result += 31 * result + this.cullmask.hashCode();
		result += 31 * result + this.sbtRecordOffset.hashCode();
		result += 31 * result + this.sbtRecordStride.hashCode();
		result += 31 * result + this.missIndex.hashCode();
		result += 31 * result + this.origin.hashCode();
		result += 31 * result + this.tMin.hashCode();
		result += 31 * result + this.direction.hashCode();
		result += 31 * result + this.tMax.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}