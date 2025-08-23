package spirv.instructions.reserved;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpExecuteCallableKHR implements ReservedInstruction {
	public Instruction sbtIndex;
	public Instruction callableData;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.sbtIndex = instructions[data[offset]];
		this.callableData = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.sbtIndex);
		writer.write(this.callableData);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXECUTE_CALLABLE_KHR;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "RayTracingKHR" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_KHR_ray_tracing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExecuteCallableKHR)) {
			return false;
		}
		OpExecuteCallableKHR other = (OpExecuteCallableKHR) o;
		if (!this.sbtIndex.equals(other.sbtIndex)) {
			return false;
		}
		return this.callableData.equals(other.callableData);
	}

	@Override
	public int hashCode() {
		int result = this.sbtIndex.hashCode();
		return 31 * result + this.callableData.hashCode();
	}
}