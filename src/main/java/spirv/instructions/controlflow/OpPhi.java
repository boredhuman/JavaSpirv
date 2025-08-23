package spirv.instructions.controlflow;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.enumerants.PairIdRefIdRef;
import spirv.instructions.Instruction;
import spirv.instructions.ResultType;
import spirv.instructions.Result;

public class OpPhi implements ControlFlowInstruction, ResultType, Result {
	public Instruction idResultType;
	public int idResult;
	public PairIdRefIdRef[] variable;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.idResultType = instructions[data[offset]];
		this.idResult = data[offset + 1];
		this.variable = new PairIdRefIdRef[(length - 2) / 2];
		for (int i = 0; i < this.variable.length; i++) {
			this.variable[i] = new PairIdRefIdRef(instructions[data[offset + 2 + i * 2]], instructions[data[offset + 2 + i * 2 + 1]]);
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.variable == null ? 0 : this.variable.length * 2;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.idResultType);
		writer.write(this.idResult);
		if (this.variable != null) {
			for (int i = 0; i < this.variable.length; i++) {
				this.variable[i].write(writer);
			}
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_PHI;
	}

	@Override
	public Instruction resultType() {
		return this.idResultType;
	}

	@Override
	public void setResultType(Instruction resultType) {
		this.idResultType = resultType;
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
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpPhi)) {
			return false;
		}
		OpPhi other = (OpPhi) o;
		if (!this.idResultType.equals(other.idResultType)) {
			return false;
		}
		if (this.idResult != other.idResult) {
			return false;
		}
		return Arrays.equals(this.variable, other.variable);
	}

	@Override
	public int hashCode() {
		int result = this.idResultType.hashCode();
		result += 31 * result + this.idResult;
		return 31 * result + Arrays.hashCode(this.variable);
	}
}