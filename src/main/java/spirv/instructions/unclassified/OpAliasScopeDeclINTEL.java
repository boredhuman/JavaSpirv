package spirv.instructions.unclassified;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpAliasScopeDeclINTEL implements Instruction, Result {
	public int idResult;
	public Instruction aliasDomain;
	public Instruction name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		this.aliasDomain = instructions[data[offset + 1]];
		if (length - 2 <= 0) {
			return;
		}
		this.name = instructions[data[offset + 2]];
	}

	@Override
	public int size() {
		int size = 2;
		size += this.name == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		writer.write(this.aliasDomain);
		if (this.name != null) {
			writer.write(this.name);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ALIAS_SCOPE_DECL_INTEL;
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
		if (!(o instanceof OpAliasScopeDeclINTEL)) {
			return false;
		}
		OpAliasScopeDeclINTEL other = (OpAliasScopeDeclINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		if (!this.aliasDomain.equals(other.aliasDomain)) {
			return false;
		}
		return Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		result += 31 * result + this.aliasDomain.hashCode();
		return 31 * result + Objects.hashCode(this.name);
	}
}