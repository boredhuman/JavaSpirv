package dev.boredhuman;

import spirv.instructions.Instruction;
import spirv.instructions.function.OpFunction;
import spirv.instructions.function.OpFunctionEnd;
import spirv.instructions.function.OpFunctionParameter;

import java.util.List;

public class SpirvFunction {
	public OpFunction function;
	public List<OpFunctionParameter> parameterList;
	public List<Instruction> body;
	public OpFunctionEnd functionEnd;

	public SpirvFunction(OpFunction function, List<OpFunctionParameter> parameterList, List<Instruction> body, OpFunctionEnd functionEnd) {
		this.function = function;
		this.parameterList = parameterList;
		this.body = body;
		this.functionEnd = functionEnd;
	}
}
