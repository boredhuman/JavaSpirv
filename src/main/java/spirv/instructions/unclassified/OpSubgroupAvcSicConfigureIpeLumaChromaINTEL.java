package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcSicConfigureIpeLumaChromaINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction lumaIntraPartitionMask;
	public Instruction intraNeighbourAvailabilty;
	public Instruction leftEdgeLumaPixels;
	public Instruction upperLeftCornerLumaPixel;
	public Instruction upperEdgeLumaPixels;
	public Instruction upperRightEdgeLumaPixels;
	public Instruction leftEdgeChromaPixels;
	public Instruction upperLeftCornerChromaPixel;
	public Instruction upperEdgeChromaPixels;
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
		this.leftEdgeChromaPixels = instructions[data[offset + 8]];
		this.upperLeftCornerChromaPixel = instructions[data[offset + 9]];
		this.upperEdgeChromaPixels = instructions[data[offset + 10]];
		this.sadAdjustment = instructions[data[offset + 11]];
		this.payload = instructions[data[offset + 12]];
	}

	@Override
	public int size() {
		return 13;
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
		writer.write(this.leftEdgeChromaPixels);
		writer.write(this.upperLeftCornerChromaPixel);
		writer.write(this.upperEdgeChromaPixels);
		writer.write(this.sadAdjustment);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_SIC_CONFIGURE_IPE_LUMA_CHROMA_INTEL;
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
		 return new String[] { "SubgroupAvcMotionEstimationINTEL", "SubgroupAvcMotionEstimationChromaINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSubgroupAvcSicConfigureIpeLumaChromaINTEL)) {
			return false;
		}
		OpSubgroupAvcSicConfigureIpeLumaChromaINTEL other = (OpSubgroupAvcSicConfigureIpeLumaChromaINTEL) o;
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
		if (!this.leftEdgeChromaPixels.equals(other.leftEdgeChromaPixels)) {
			return false;
		}
		if (!this.upperLeftCornerChromaPixel.equals(other.upperLeftCornerChromaPixel)) {
			return false;
		}
		if (!this.upperEdgeChromaPixels.equals(other.upperEdgeChromaPixels)) {
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
		result += 31 * result + this.leftEdgeChromaPixels.hashCode();
		result += 31 * result + this.upperLeftCornerChromaPixel.hashCode();
		result += 31 * result + this.upperEdgeChromaPixels.hashCode();
		result += 31 * result + this.sadAdjustment.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}