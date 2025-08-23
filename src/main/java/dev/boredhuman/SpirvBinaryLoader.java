package dev.boredhuman;

import spirv.instructions.Instruction;
import spirv.instructions.InstructionRegistry;
import spirv.instructions.Result;
import spirv.instructions.ResultType;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class SpirvBinaryLoader {

	public static SpirvBinary loadBinary(InputStream stream) {
		return SpirvBinaryLoader.loadBinary(Util.asByteArray(stream));
	}

	public static int size(SpirvBinary binary) {
		int size = 0;
		for (Instruction instruction : binary.instructions) {
			size += instruction.size();
		}
		size += binary.instructions.length;
		return size + 5;
	}

	public static SpirvBinary loadBinary(byte[] binaryData) {
		ByteBuffer binaryBuffer = ByteBuffer.wrap(binaryData);

		int magic = binaryBuffer.getInt(0);
		if (magic == Integer.reverseBytes(0x07230203)) {
			binaryBuffer.order(ByteOrder.LITTLE_ENDIAN);
		} else if (magic != 0x07230203) {
			throw new RuntimeException("Invalid magic word!");
		}

		int[] words = new int[binaryData.length / 4];

		binaryBuffer.asIntBuffer().get(words);

		SpirvBinary spirvBinary = new SpirvBinary();
		spirvBinary.magicNumber = words[0];
		spirvBinary.majorVersion = (words[1] >> 16) & 0xFF;
		spirvBinary.minorVersion = (words[1] >> 8) & 0xFF;
		spirvBinary.generateMagicNumber = words[2];
		spirvBinary.bound = words[3];
		spirvBinary.reserved = words[4];

		Instruction[] identifiedInstructions = new Instruction[spirvBinary.bound];
		List<Instruction> instructionList = new ArrayList<>();

		int index = 5;
		while (index < words.length) {
			int wordCount = words[index];
			int length = (wordCount >> 16) & 0xFFFF;
			int opcode = wordCount & 0xFFFF;

			try {
				Instruction instruction = InstructionRegistry.INSTRUCTION_REGISTRY[opcode].get();
				instructionList.add(instruction);

				if (instruction instanceof Result) {
					if (instruction instanceof ResultType) {
						identifiedInstructions[words[index + 2]] = instruction;
					} else {
						identifiedInstructions[words[index + 1]] = instruction;
					}
				}
			} catch (Throwable err) {
				throw new RuntimeException("Failed to create instruction", err);
			}

			index += length;
		}

		spirvBinary.instructions = instructionList.toArray(new Instruction[0]);
		Instruction[] instructions = spirvBinary.instructions;

		index = 5;
		int instructionIndex = 0;
		while (index < words.length) {
			int wordCount = words[index];
			int length = (wordCount >> 16) & 0xFFFF;

			Instruction instruction = instructions[instructionIndex];

			instruction.load(words, index + 1, length - 1, identifiedInstructions);

			index += length;
			instructionIndex++;
		}

		return spirvBinary;
	}
}
