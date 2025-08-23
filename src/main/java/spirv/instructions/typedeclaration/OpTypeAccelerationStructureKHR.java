package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeAccelerationStructureKHR implements TypeDeclarationInstruction, Result {
	public int idResult;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_ACCELERATION_STRUCTURE_KHR;
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
		 return new String[] { "RayTracingNV", "RayTracingKHR", "RayQueryKHR", "DisplacementMicromapNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_ray_tracing", "SPV_KHR_ray_tracing", "SPV_KHR_ray_query", "SPV_NV_displacement_micromap" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeAccelerationStructureKHR)) {
			return false;
		}
		OpTypeAccelerationStructureKHR other = (OpTypeAccelerationStructureKHR) o;
		return this.idResult != other.idResult;
	}

	@Override
	public int hashCode() {
		return this.idResult;
	}
}