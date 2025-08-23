package spirv.instructions;

public interface Instruction {
	int opcode();

	default void load(int[] data, int offset, int length, Instruction[] instructions) {

	}

	default int size() {
		return 0;
	}

	default void write(InstructionWriter writer) {

	}

	default String[] capabilities() {
		return new String[] {};
	}

	default String[] extensions() {
		return new String[] {};
	}

	String version();
}
