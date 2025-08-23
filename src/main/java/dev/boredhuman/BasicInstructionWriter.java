package dev.boredhuman;

import spirv.instructions.Instruction;
import spirv.instructions.InstructionUtil;
import spirv.instructions.InstructionWriter;
import spirv.instructions.Result;
import spirv.instructions.ValueEnum;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

public class BasicInstructionWriter implements InstructionWriter {

	public int[] data;
	private int offset;

	public BasicInstructionWriter(int[] data, int offset) {
		this.data = data;
		this.offset = offset;
	}

	public int offset() {
		return this.offset;
	}

	@Override
	public void write(int data) {
		this.data[this.offset++] = data;
	}

	@Override
	public void write(Object data) {
		if (data instanceof Integer) {
			this.write(((Integer) data).intValue());
		} else if (data instanceof Float) {
			this.write(Float.floatToRawIntBits((Float) data));
		} else if (data instanceof ValueEnum) {
			this.write(((ValueEnum) data).value());
		} else if (data instanceof Result) {
			this.write(((Result) data).result());
		} else if (data instanceof String) {
			byte[] stringBytes = ((String) data).getBytes(StandardCharsets.UTF_8);
			InstructionUtil.writeString(this.data, this.offset, stringBytes);
			this.offset += InstructionUtil.wordCount(stringBytes);
		} else if (data instanceof int[]) {
			int[] dataArray = (int[]) data;

			for (int dataElement : dataArray) {
				this.write(dataElement);
			}
		} else if (data.getClass().isArray()) {
			int length = Array.getLength(data);
			for (int i = 0; i < length; i++) {
				this.write(Array.get(data, i));
			}
		} else {
			throw new RuntimeException("Writer: Unsupported type " + data.getClass().getName());
		}
	}

	@Override
	public void writeInnerInstruction(Instruction instruction) {
		int[] swap = new int[instruction.size()];
		BasicInstructionWriter basicWriter = new BasicInstructionWriter(swap, 0);
		instruction.write(basicWriter);
		// skip result type and result id
		for (int i = 2; i < swap.length; i++) {
			this.write(swap[i]);
		}
	}
}
