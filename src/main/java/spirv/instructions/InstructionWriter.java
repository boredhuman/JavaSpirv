package spirv.instructions;

public interface InstructionWriter {
	void write(int data);

	void write(Object data);

	// used by LiteralSpecConstantOpInteger to emit the inner opcode arguments
	void writeInnerInstruction(Instruction instruction);
}
