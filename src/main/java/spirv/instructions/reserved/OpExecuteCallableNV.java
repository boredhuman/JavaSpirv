package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpExecuteCallableNV implements ReservedInstruction {
	public Instruction sbtIndex;
	public Instruction callableDataId;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.sbtIndex = instructions[data[offset]];
		this.callableDataId = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.sbtIndex);
		writer.write(this.callableDataId);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXECUTE_CALLABLE_NV;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingNV" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_NV_ray_tracing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExecuteCallableNV)) {
			return false;
		}
		OpExecuteCallableNV other = (OpExecuteCallableNV) o;
		if (!this.sbtIndex.equals(other.sbtIndex)) {
			return false;
		}
		return this.callableDataId.equals(other.callableDataId);
	}

	@Override
	public int hashCode() {
		int result = this.sbtIndex.hashCode();
		return 31 * result + this.callableDataId.hashCode();
	}
}