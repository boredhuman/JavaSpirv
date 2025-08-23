package spirv.instructions.modesetting;

import spirv.enumerants.AddressingModel;
import spirv.enumerants.MemoryModel;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpMemoryModel implements ModeSettingInstruction {
	public AddressingModel addressingModel;
	public MemoryModel memoryModel;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.addressingModel = AddressingModel.get(data[offset]);
		this.memoryModel = MemoryModel.get(data[offset + 1]);
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.addressingModel);
		writer.write(this.memoryModel);
	}

	@Override
	public int opcode() {
		return OpCodes.OP_MEMORY_MODEL;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpMemoryModel)) {
			return false;
		}
		OpMemoryModel other = (OpMemoryModel) o;
		if (this.addressingModel != other.addressingModel) {
			return false;
		}
		return this.memoryModel != other.memoryModel;
	}

	@Override
	public int hashCode() {
		int result = this.addressingModel.hashCode();
		return 31 * result + this.memoryModel.hashCode();
	}
}