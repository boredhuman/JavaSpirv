package spirv.instructions.arithmetic;

import spirv.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ArithmeticInstructionRegistry {

	public static final Map<Integer, Supplier<Instruction>> ARITHMETIC_INSTRUCTIONS_REGISTRY = new HashMap<>();

	static {
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(126, OpSNegate::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(127, OpFNegate::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(128, OpIAdd::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(129, OpFAdd::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(130, OpISub::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(131, OpFSub::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(132, OpIMul::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(133, OpFMul::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(134, OpUDiv::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(135, OpSDiv::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(136, OpFDiv::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(137, OpUMod::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(138, OpSRem::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(139, OpSMod::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(140, OpFRem::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(141, OpFMod::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(142, OpVectorTimesScalar::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(143, OpMatrixTimesScalar::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(144, OpVectorTimesMatrix::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(145, OpMatrixTimesVector::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(146, OpMatrixTimesMatrix::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(147, OpOuterProduct::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(148, OpDot::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(149, OpIAddCarry::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(150, OpISubBorrow::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(151, OpUMulExtended::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(152, OpSMulExtended::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4450, OpSDot::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4451, OpUDot::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4452, OpSUDot::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4453, OpSDotAccSat::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4454, OpUDotAccSat::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4455, OpSUDotAccSat::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(4459, OpCooperativeMatrixMulAddKHR::new);
		ArithmeticInstructionRegistry.ARITHMETIC_INSTRUCTIONS_REGISTRY.put(5366, OpCooperativeMatrixReduceNV::new);
	}
}