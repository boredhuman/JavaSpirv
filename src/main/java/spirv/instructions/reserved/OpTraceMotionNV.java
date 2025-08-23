package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpTraceMotionNV implements ReservedInstruction {
	public Instruction accel;
	public Instruction rayFlags;
	public Instruction cullMask;
	public Instruction sbtOffset;
	public Instruction sbtStride;
	public Instruction missIndex;
	public Instruction rayOrigin;
	public Instruction rayTmin;
	public Instruction rayDirection;
	public Instruction rayTmax;
	public Instruction time;
	public Instruction payloadId;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.accel = instructions[data[offset]];
		this.rayFlags = instructions[data[offset + 1]];
		this.cullMask = instructions[data[offset + 2]];
		this.sbtOffset = instructions[data[offset + 3]];
		this.sbtStride = instructions[data[offset + 4]];
		this.missIndex = instructions[data[offset + 5]];
		this.rayOrigin = instructions[data[offset + 6]];
		this.rayTmin = instructions[data[offset + 7]];
		this.rayDirection = instructions[data[offset + 8]];
		this.rayTmax = instructions[data[offset + 9]];
		this.time = instructions[data[offset + 10]];
		this.payloadId = instructions[data[offset + 11]];
	}

	@Override
	public int size() {
		return 12;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.accel);
		writer.write(this.rayFlags);
		writer.write(this.cullMask);
		writer.write(this.sbtOffset);
		writer.write(this.sbtStride);
		writer.write(this.missIndex);
		writer.write(this.rayOrigin);
		writer.write(this.rayTmin);
		writer.write(this.rayDirection);
		writer.write(this.rayTmax);
		writer.write(this.time);
		writer.write(this.payloadId);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TRACE_MOTION_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingMotionBlurNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_ray_tracing_motion_blur" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTraceMotionNV)) {
			return false;
		}
		OpTraceMotionNV other = (OpTraceMotionNV) o;
		if (!this.accel.equals(other.accel)) {
			return false;
		}
		if (!this.rayFlags.equals(other.rayFlags)) {
			return false;
		}
		if (!this.cullMask.equals(other.cullMask)) {
			return false;
		}
		if (!this.sbtOffset.equals(other.sbtOffset)) {
			return false;
		}
		if (!this.sbtStride.equals(other.sbtStride)) {
			return false;
		}
		if (!this.missIndex.equals(other.missIndex)) {
			return false;
		}
		if (!this.rayOrigin.equals(other.rayOrigin)) {
			return false;
		}
		if (!this.rayTmin.equals(other.rayTmin)) {
			return false;
		}
		if (!this.rayDirection.equals(other.rayDirection)) {
			return false;
		}
		if (!this.rayTmax.equals(other.rayTmax)) {
			return false;
		}
		if (!this.time.equals(other.time)) {
			return false;
		}
		return this.payloadId.equals(other.payloadId);
	}

	@Override
	public int hashCode() {
		int result = this.accel.hashCode();
		result += 31 * result + this.rayFlags.hashCode();
		result += 31 * result + this.cullMask.hashCode();
		result += 31 * result + this.sbtOffset.hashCode();
		result += 31 * result + this.sbtStride.hashCode();
		result += 31 * result + this.missIndex.hashCode();
		result += 31 * result + this.rayOrigin.hashCode();
		result += 31 * result + this.rayTmin.hashCode();
		result += 31 * result + this.rayDirection.hashCode();
		result += 31 * result + this.rayTmax.hashCode();
		result += 31 * result + this.time.hashCode();
		return 31 * result + this.payloadId.hashCode();
	}
}