package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpHitObjectRecordHitNV implements ReservedInstruction {
	public Instruction hitObject;
	public Instruction accelerationStructure;
	public Instruction instanceId;
	public Instruction primitiveId;
	public Instruction geometryIndex;
	public Instruction hitKind;
	public Instruction sbtRecordOffset;
	public Instruction sbtRecordStride;
	public Instruction origin;
	public Instruction tMin;
	public Instruction direction;
	public Instruction tMax;
	public Instruction hitObjectAttributes;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.hitObject = instructions[data[offset]];
		this.accelerationStructure = instructions[data[offset + 1]];
		this.instanceId = instructions[data[offset + 2]];
		this.primitiveId = instructions[data[offset + 3]];
		this.geometryIndex = instructions[data[offset + 4]];
		this.hitKind = instructions[data[offset + 5]];
		this.sbtRecordOffset = instructions[data[offset + 6]];
		this.sbtRecordStride = instructions[data[offset + 7]];
		this.origin = instructions[data[offset + 8]];
		this.tMin = instructions[data[offset + 9]];
		this.direction = instructions[data[offset + 10]];
		this.tMax = instructions[data[offset + 11]];
		this.hitObjectAttributes = instructions[data[offset + 12]];
	}

	@Override
	public int size() {
		return 13;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.hitObject);
		writer.write(this.accelerationStructure);
		writer.write(this.instanceId);
		writer.write(this.primitiveId);
		writer.write(this.geometryIndex);
		writer.write(this.hitKind);
		writer.write(this.sbtRecordOffset);
		writer.write(this.sbtRecordStride);
		writer.write(this.origin);
		writer.write(this.tMin);
		writer.write(this.direction);
		writer.write(this.tMax);
		writer.write(this.hitObjectAttributes);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_HIT_OBJECT_RECORD_HIT_NV;
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
		if (!(o instanceof OpHitObjectRecordHitNV)) {
			return false;
		}
		OpHitObjectRecordHitNV other = (OpHitObjectRecordHitNV) o;
		if (!this.hitObject.equals(other.hitObject)) {
			return false;
		}
		if (!this.accelerationStructure.equals(other.accelerationStructure)) {
			return false;
		}
		if (!this.instanceId.equals(other.instanceId)) {
			return false;
		}
		if (!this.primitiveId.equals(other.primitiveId)) {
			return false;
		}
		if (!this.geometryIndex.equals(other.geometryIndex)) {
			return false;
		}
		if (!this.hitKind.equals(other.hitKind)) {
			return false;
		}
		if (!this.sbtRecordOffset.equals(other.sbtRecordOffset)) {
			return false;
		}
		if (!this.sbtRecordStride.equals(other.sbtRecordStride)) {
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
		return this.hitObjectAttributes.equals(other.hitObjectAttributes);
	}

	@Override
	public int hashCode() {
		int result = this.hitObject.hashCode();
		result += 31 * result + this.accelerationStructure.hashCode();
		result += 31 * result + this.instanceId.hashCode();
		result += 31 * result + this.primitiveId.hashCode();
		result += 31 * result + this.geometryIndex.hashCode();
		result += 31 * result + this.hitKind.hashCode();
		result += 31 * result + this.sbtRecordOffset.hashCode();
		result += 31 * result + this.sbtRecordStride.hashCode();
		result += 31 * result + this.origin.hashCode();
		result += 31 * result + this.tMin.hashCode();
		result += 31 * result + this.direction.hashCode();
		result += 31 * result + this.tMax.hashCode();
		return 31 * result + this.hitObjectAttributes.hashCode();
	}
}