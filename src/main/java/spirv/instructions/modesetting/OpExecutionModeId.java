package spirv.instructions.modesetting;

import java.util.Arrays;
import spirv.enumerants.ExecutionMode;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpExecutionModeId implements ModeSettingInstruction {
	public Instruction entryPoint;
	public ExecutionMode mode;
	public Object[] modeArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.entryPoint = instructions[data[offset]];
		this.mode = ExecutionMode.get(data[offset + 1]);
		this.modeArg = this.mode.loadArg(data, offset + 2, instructions);
	}

	@Override
	public int size() {
		int size = 2;
		size += this.mode.argumentCount;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.entryPoint);
		writer.write(this.mode);
		if (this.mode.argumentCount > 0) {
			writer.write(this.modeArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_EXECUTION_MODE_ID;
	}

	@Override
	public String version() {
		return "1.2";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpExecutionModeId)) {
			return false;
		}
		OpExecutionModeId other = (OpExecutionModeId) o;
		if (!this.entryPoint.equals(other.entryPoint)) {
			return false;
		}
		if (this.mode != other.mode) {
			return false;
		}
		return Arrays.equals(this.modeArg, other.modeArg);
	}

	@Override
	public int hashCode() {
		int result = this.entryPoint.hashCode();
		result += 31 * result + this.mode.hashCode();
		return 31 * result + Arrays.hashCode(this.modeArg);
	}
}