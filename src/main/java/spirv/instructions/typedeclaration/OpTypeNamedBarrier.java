package spirv.instructions.typedeclaration;

import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpTypeNamedBarrier implements TypeDeclarationInstruction, Result {
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
		return OpCodes.OP_TYPE_NAMED_BARRIER;
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
		 return new String[] { "NamedBarrier" };
	}

	@Override
	public String version() {
		return "1.1";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTypeNamedBarrier)) {
			return false;
		}
		OpTypeNamedBarrier other = (OpTypeNamedBarrier) o;
		return this.idResult != other.idResult;
	}

	@Override
	public int hashCode() {
		return this.idResult;
	}
}