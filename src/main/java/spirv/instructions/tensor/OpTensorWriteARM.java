package spirv.instructions.tensor;

import java.util.Objects;
import spirv.instructions.BitMask;
import java.util.Arrays;
import spirv.enumerants.TensorOperands;
import spirv.instructions.InstructionWriter;
import spirv.instructions.OpCodes;
import spirv.instructions.Instruction;

public class OpTensorWriteARM implements TensorInstruction {
	public Instruction tensor;
	public Instruction coordinates;
	public Instruction object;
	@BitMask(TensorOperands.class)
	public int tensorOperands;
	public Instruction[] tensorOperandsArg;

	@Override
	public void load(int[] data, int offset, int length, Instruction[] instructions) {
		this.tensor = instructions[data[offset]];
		this.coordinates = instructions[data[offset + 1]];
		this.object = instructions[data[offset + 2]];
		if (length - 3 <= 0) {
			return;
		}
		this.tensorOperands = data[offset + 3];
		this.tensorOperandsArg = new Instruction[TensorOperands.getArgumentCount(this.tensorOperands)];
		for (int i = 0; i < this.tensorOperandsArg.length; i++) {
			this.tensorOperandsArg[i] = instructions[data[offset + 4 + i]];
		}
	}

	@Override
	public int size() {
		int size = 3;
		size += this.tensorOperands == 0 ? 0 : 1;
		size += TensorOperands.getArgumentCount(this.tensorOperands);
		return size;
	}

	@Override
	public void write(InstructionWriter writer) {
		writer.write(this.tensor);
		writer.write(this.coordinates);
		writer.write(this.object);
		if (this.tensorOperands > 0) {
			writer.write(this.tensorOperands);
			writer.write(this.tensorOperandsArg);
		}
	}

	@Override
	public int opcode() {
		return OpCodes.OP_TENSOR_WRITE_ARM;
	}

	@Override
	public String[] capabilities() {
		 return new String[] { "TensorsARM" };
	}

	@Override
	public String version() {
		return "None";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OpTensorWriteARM)) {
			return false;
		}
		OpTensorWriteARM other = (OpTensorWriteARM) o;
		if (!this.tensor.equals(other.tensor)) {
			return false;
		}
		if (!this.coordinates.equals(other.coordinates)) {
			return false;
		}
		if (!this.object.equals(other.object)) {
			return false;
		}
		if (!Objects.equals(this.tensorOperands, other.tensorOperands)) {
			return false;
		}
		return Arrays.equals(this.tensorOperandsArg, other.tensorOperandsArg);
	}

	@Override
	public int hashCode() {
		int result = this.tensor.hashCode();
		result += 31 * result + this.coordinates.hashCode();
		result += 31 * result + this.object.hashCode();
		result += 31 * result + Objects.hashCode(this.tensorOperands);
		return 31 * result + Arrays.hashCode(this.tensorOperandsArg);
	}
}