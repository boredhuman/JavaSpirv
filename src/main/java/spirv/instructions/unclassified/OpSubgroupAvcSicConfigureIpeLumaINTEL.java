package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicConfigureIpeLumaINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction lumaIntraPartitionMask;
	public Instruction intraNeighbourAvailabilty;
	public Instruction leftEdgeLumaPixels;
	public Instruction upperLeftCornerLumaPixel;
	public Instruction upperEdgeLumaPixels;
	public Instruction upperRightEdgeLumaPixels;
	public Instruction sadAdjustment;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.lumaIntraPartitionMask = instructions[data[offset + 2]];
		this.intraNeighbourAvailabilty = instructions[data[offset + 3]];
		this.leftEdgeLumaPixels = instructions[data[offset + 4]];
		this.upperLeftCornerLumaPixel = instructions[data[offset + 5]];
		this.upperEdgeLumaPixels = instructions[data[offset + 6]];
		this.upperRightEdgeLumaPixels = instructions[data[offset + 7]];
		this.sadAdjustment = instructions[data[offset + 8]];
		this.payload = instructions[data[offset + 9]];
	}

	@Override
	public int size() {
		return 10;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.lumaIntraPartitionMask);
		writer.write(this.intraNeighbourAvailabilty);
		writer.write(this.leftEdgeLumaPixels);
		writer.write(this.upperLeftCornerLumaPixel);
		writer.write(this.upperEdgeLumaPixels);
		writer.write(this.upperRightEdgeLumaPixels);
		writer.write(this.sadAdjustment);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_CONFIGURE_IPE_LUMA_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL", "SubgroupAvcMotionEstimationIntraINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcSicConfigureIpeLumaINTEL)) {
			return false;
		}
		OpSubgroupAvcSicConfigureIpeLumaINTEL other = (OpSubgroupAvcSicConfigureIpeLumaINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.lumaIntraPartitionMask.equals(other.lumaIntraPartitionMask)) {
			return false;
		}
		if (!this.intraNeighbourAvailabilty.equals(other.intraNeighbourAvailabilty)) {
			return false;
		}
		if (!this.leftEdgeLumaPixels.equals(other.leftEdgeLumaPixels)) {
			return false;
		}
		if (!this.upperLeftCornerLumaPixel.equals(other.upperLeftCornerLumaPixel)) {
			return false;
		}
		if (!this.upperEdgeLumaPixels.equals(other.upperEdgeLumaPixels)) {
			return false;
		}
		if (!this.upperRightEdgeLumaPixels.equals(other.upperRightEdgeLumaPixels)) {
			return false;
		}
		if (!this.sadAdjustment.equals(other.sadAdjustment)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.lumaIntraPartitionMask.hashCode();
		result += 31 * result + this.intraNeighbourAvailabilty.hashCode();
		result += 31 * result + this.leftEdgeLumaPixels.hashCode();
		result += 31 * result + this.upperLeftCornerLumaPixel.hashCode();
		result += 31 * result + this.upperEdgeLumaPixels.hashCode();
		result += 31 * result + this.upperRightEdgeLumaPixels.hashCode();
		result += 31 * result + this.sadAdjustment.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}