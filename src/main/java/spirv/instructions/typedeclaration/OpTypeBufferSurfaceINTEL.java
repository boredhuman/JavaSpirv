package spirv.instructions.typedeclaration;

import spirv.enumerants.AccessQualifier;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeBufferSurfaceINTEL implements TypeDeclarationInstruction, Result {
	public int idResult;
	public AccessQualifier accessQualifier;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.accessQualifier = AccessQualifier.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.accessQualifier);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TYPE_BUFFER_SURFACE_INTEL;
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
		 return new String[] { "VectorComputeINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeBufferSurfaceINTEL)) {
			return false;
		}
		OpTypeBufferSurfaceINTEL other = (OpTypeBufferSurfaceINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return this.accessQualifier != other.accessQualifier;
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + this.accessQualifier.hashCode();
	}
}