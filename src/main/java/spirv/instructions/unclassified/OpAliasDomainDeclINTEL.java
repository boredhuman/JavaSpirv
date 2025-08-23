package spirv.instructions.unclassified;

import java.util.Objects;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.instructions.Result;

public class OpAliasDomainDeclINTEL implements Instruction, Result {
	public int idResult;
	public Instruction name;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResult = data[offset];
		if (length - 1 <= 0) {
			return;
		}
		this.name = instructions[data[offset + 1]];
	}

	@Override
	public int size() {
		int size = 1;
		size += this.name == null ? 0 : 1;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResult);
		if (this.name != null) {
			writer.write(this.name);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_ALIAS_DOMAIN_DECL_INTEL;
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
		if (!(o instanceof OpAliasDomainDeclINTEL)) {
			return false;
		}
		OpAliasDomainDeclINTEL other = (OpAliasDomainDeclINTEL) o;
		if (this.idResult != other.idResult) {
			return false;
		}
		return Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode() {
		int result = this.idResult;
		return 31 * result + Objects.hashCode(this.name);
	}
}