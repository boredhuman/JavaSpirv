package spirv.instructions.unclassified;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpAliasScopeListDeclINTEL implements Instruction, Result {
	public int idResult;
	public Instruction[] aliasScope1;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.aliasScope1 = new Instruction[length - 1];
		for (int i = 0; i < this.aliasScope1.length; i++) {
			this.aliasScope1[i] = instructions[data[offset + 1 + i]];
		}
	}

	@Override
	public int size() {
		int size = 1;
		size += this.aliasScope1 == null ? 0 : this.aliasScope1.length;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		if (this.aliasScope1 != null) {
			writer.write(this.aliasScope1);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ALIAS_SCOPE_LIST_DECL_INTEL;
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
		 return new String[] { "MemoryAccessAliasingINTEL" };
	}

	@Override
	public String[] extensions() {
		 return new String[] { "SPV_INTEL_memory_access_aliasing" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpAliasScopeListDeclINTEL)) {
			return false;
		}
		OpAliasScopeListDeclINTEL other = (OpAliasScopeListDeclINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.aliasScope1, other.aliasScope1);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + Arrays.hashCode(this.aliasScope1);
	}
}