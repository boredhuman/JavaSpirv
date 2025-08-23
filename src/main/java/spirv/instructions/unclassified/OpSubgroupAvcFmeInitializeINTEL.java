package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcFmeInitializeINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction srcCoord;
	public Instruction motionVectors;
	public Instruction majorShapes;
	public Instruction minorShapes;
	public Instruction direction;
	public Instruction pixelResolution;
	public Instruction sadAdjustment;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.srcCoord = instructions[data[offset + 2]];
		this.motionVectors = instructions[data[offset + 3]];
		this.majorShapes = instructions[data[offset + 4]];
		this.minorShapes = instructions[data[offset + 5]];
		this.direction = instructions[data[offset + 6]];
		this.pixelResolution = instructions[data[offset + 7]];
		this.sadAdjustment = instructions[data[offset + 8]];
	}

	@Override
	public int size() {
		return 9;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.srcCoord);
		writer.write(this.motionVectors);
		writer.write(this.majorShapes);
		writer.write(this.minorShapes);
		writer.write(this.direction);
		writer.write(this.pixelResolution);
		writer.write(this.sadAdjustment);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_FME_INITIALIZE_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcFmeInitializeINTEL)) {
			return false;
		}
		OpSubgroupAvcFmeInitializeINTEL other = (OpSubgroupAvcFmeInitializeINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.srcCoord.equals(other.srcCoord)) {
			return false;
		}
		if (!this.motionVectors.equals(other.motionVectors)) {
			return false;
		}
		if (!this.majorShapes.equals(other.majorShapes)) {
			return false;
		}
		if (!this.minorShapes.equals(other.minorShapes)) {
			return false;
		}
		if (!this.direction.equals(other.direction)) {
			return false;
		}
		if (!this.pixelResolution.equals(other.pixelResolution)) {
			return false;
		}
		return this.sadAdjustment.equals(other.sadAdjustment);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.srcCoord.hashCode();
		result += 31 * result + this.motionVectors.hashCode();
		result += 31 * result + this.majorShapes.hashCode();
		result += 31 * result + this.minorShapes.hashCode();
		result += 31 * result + this.direction.hashCode();
		result += 31 * result + this.pixelResolution.hashCode();
		return 31 * result + this.sadAdjustment.hashCode();
	}
}