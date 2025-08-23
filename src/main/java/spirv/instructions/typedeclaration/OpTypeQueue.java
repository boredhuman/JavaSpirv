package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeQueue implements TypeDeclarationInstruction, Result {
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
		return OpCodes.OP_TYPE_QUEUE;
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
		 return new String[] { "DeviceEnqueue" };
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeQueue)) {
			return false;
		}
		OpTypeQueue other = (OpTypeQueue) o;
		return this.idResult != other.idResult;
	}

	@Override
	public int hashCode() {
		return this.idResult;
	}
}