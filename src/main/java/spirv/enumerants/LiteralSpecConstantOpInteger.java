package spirv.enumerants;

import spirv.instructions.InstructionRegistry;
import spirv.instructions.InstructionWriter;
import spirv.instructions.Instruction;

public class LiteralSpecConstantOpInteger {
	public int opcode;
	public Instruction instruction;

	public LiteralSpecConstantOpInteger(int[] data, int offset, int length, Instruction[] instructions) {
		this.opcode = data[offset + 2];
		this.instruction = InstructionRegistry.INSTRUCTION_REGISTRY[this.opcode].get();
		int[] innerData = new int[length - 3 + 2];
		innerData[0] = data[offset];
		innerData[1] = data[offset + 1];
		System.arraycopy(data, offset + 3, innerData, 2, innerData.length - 2);
		this.instruction.load(innerData, 0, innerData.length, instructions);
	}

	public int size() {
		return 1 + this.instruction.size() - 2;
	}

	public void write(InstructionWriter writer) {
		writer.write(this.opcode);
		writer.writeInnerInstruction(this.instruction);
	}
}
