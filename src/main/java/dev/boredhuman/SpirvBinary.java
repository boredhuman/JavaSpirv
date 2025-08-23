package dev.boredhuman;

import spirv.instructions.Instruction;

public class SpirvBinary {
	public int magicNumber;
	public int majorVersion;
	public int minorVersion;
	public int generateMagicNumber;
	public int bound;
	public int reserved;
	public Instruction[] instructions;
}
