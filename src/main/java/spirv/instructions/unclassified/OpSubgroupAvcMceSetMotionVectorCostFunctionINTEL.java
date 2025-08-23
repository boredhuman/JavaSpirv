package spirv.instructions.unclassified;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpSubgroupAvcMceSetMotionVectorCostFunctionINTEL implements Instruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public Instruction packedCostCenterDelta;
	public Instruction packedCostTable;
	public Instruction costPrecision;
	public Instruction payload;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.packedCostCenterDelta = instructions[data[offset + 2]];
		this.packedCostTable = instructions[data[offset + 3]];
		this.costPrecision = instructions[data[offset + 4]];
		this.payload = instructions[data[offset + 5]];
	}

	@Override
	public int size() {
		return 6;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		writer.write(this.packedCostCenterDelta);
		writer.write(this.packedCostTable);
		writer.write(this.costPrecision);
		writer.write(this.payload);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SUBGROUP_AVC_MCE_SET_MOTION_VECTOR_COST_FUNCTION_INTEL;
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
		if (!(o instanceof OpSubgroupAvcMceSetMotionVectorCostFunctionINTEL)) {
			return false;
		}
		OpSubgroupAvcMceSetMotionVectorCostFunctionINTEL other = (OpSubgroupAvcMceSetMotionVectorCostFunctionINTEL) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.packedCostCenterDelta.equals(other.packedCostCenterDelta)) {
			return false;
		}
		if (!this.packedCostTable.equals(other.packedCostTable)) {
			return false;
		}
		if (!this.costPrecision.equals(other.costPrecision)) {
			return false;
		}
		return this.payload.equals(other.payload);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		result += 31 * result + this.packedCostCenterDelta.hashCode();
		result += 31 * result + this.packedCostTable.hashCode();
		result += 31 * result + this.costPrecision.hashCode();
		return 31 * result + this.payload.hashCode();
	}
}