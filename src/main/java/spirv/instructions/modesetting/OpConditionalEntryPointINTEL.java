package spirv.instructions.modesetting;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.ExecutionModel;
import spirv.instructions.InstructionUtil;

public class OpConditionalEntryPointINTEL implements ModeSettingInstruction {
	public Instruction condition;
	public ExecutionModel executionModel;
	public Instruction entryPoint;
	public String name;
	public Instruction[] interfaceOperand;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.condition = instructions[data[offset]];
		this.executionModel = ExecutionModel.get(data[offset + 1]);
		this.entryPoint = instructions[data[offset + 2]];
		this.name = InstructionUtil.readString(data, offset + 3).getString();
		int dynamicOffset = InstructionUtil.wordCount(this.name) + 3;
		this.interfaceOperand = new Instruction[length - dynamicOffset];
		for (int i = 0; i < this.interfaceOperand.length; i++) {
			this.interfaceOperand[i] = instructions[data[offset + dynamicOffset + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += InstructionUtil.wordCount(this.name);
		size += this.interfaceOperand == null ? 0 : this.interfaceOperand.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.condition);
		writer.write(this.executionModel);
		writer.write(this.entryPoint);
		writer.write(this.name);
		if (this.interfaceOperand != null) {
			writer.write(this.interfaceOperand);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_CONDITIONAL_ENTRY_POINT_INTEL;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "SpecConditionalINTEL" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpConditionalEntryPointINTEL)) {
			return false;
		}
		OpConditionalEntryPointINTEL other = (OpConditionalEntryPointINTEL) o;
		if (!this.condition.equals(other.condition)) {
			return false;
		}
		if (this.executionModel != other.executionModel) {
			return false;
		}
		if (!this.entryPoint.equals(other.entryPoint)) {
			return false;
		}
		if (!this.name.equals(other.name)) {
			return false;
		}
		return Arrays.equals(this.interfaceOperand, other.interfaceOperand);
	}

	@Override
	public int hashCode() {
		int result = this.condition.hashCode();
		result += 31 * result + this.executionModel.hashCode();
		result += 31 * result + this.entryPoint.hashCode();
		result += 31 * result + this.name.hashCode();
		return 31 * result + Arrays.hashCode(this.interfaceOperand);
	}
}