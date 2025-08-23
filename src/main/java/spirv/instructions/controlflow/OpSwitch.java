package spirv.instructions.controlflow;

import java.util.Arrays;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;
import spirv.enumerants.PairLiteralIntegerIdRef;

public class OpSwitch implements ControlFlowInstruction {
	public Instruction selector;
	public Instruction defaultOperand;
	public PairLiteralIntegerIdRef[] target;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.selector = instructions[data[offset]];
		this.defaultOperand = instructions[data[offset + 1]];
		this.target = new PairLiteralIntegerIdRef[(length - 2) / 2];
		for (int i = 0; i < this.target.length; i++) {
			this.target[i] = new PairLiteralIntegerIdRef(data[offset + 2 + i * 2], instructions[data[offset + 2 + i * 2 + 1]]);
		}
	}

	@Override
	public int size() {
		int size = 2;
		size += this.target == null ? 0 : this.target.length * 2;
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.selector);
		writer.write(this.defaultOperand);
		if (this.target != null) {
			for (int i = 0; i < this.target.length; i++) {
				this.target[i].write(writer);
			}
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_SWITCH;
	}

	@Override
	public String version() {
		return "1.0";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpSwitch)) {
			return false;
		}
		OpSwitch other = (OpSwitch) o;
		if (!this.selector.equals(other.selector)) {
			return false;
		}
		if (!this.defaultOperand.equals(other.defaultOperand)) {
			return false;
		}
		return Arrays.equals(this.target, other.target);
	}

	@Override
	public int hashCode() {
		int result = this.selector.hashCode();
		result += 31 * result + this.defaultOperand.hashCode();
		return 31 * result + Arrays.hashCode(this.target);
	}
}