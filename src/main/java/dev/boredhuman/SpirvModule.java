package dev.boredhuman;

import spirv.instructions.Instruction;
import spirv.instructions.OpCodes;
import spirv.instructions.annotation.AnnotationInstruction;
import spirv.instructions.constantcreation.ConstantCreationInstruction;
import spirv.instructions.debug.DebugInstruction;
import spirv.instructions.debug.OpModuleProcessed;
import spirv.instructions.extension.OpExtInstImport;
import spirv.instructions.extension.OpExtension;
import spirv.instructions.function.OpFunction;
import spirv.instructions.function.OpFunctionEnd;
import spirv.instructions.function.OpFunctionParameter;
import spirv.instructions.memory.OpVariable;
import spirv.instructions.modesetting.ModeSettingInstruction;
import spirv.instructions.modesetting.OpCapability;
import spirv.instructions.modesetting.OpEntryPoint;
import spirv.instructions.modesetting.OpMemoryModel;
import spirv.instructions.typedeclaration.TypeDeclarationInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class SpirvModule {
	public List<OpCapability> capabilities = new ArrayList<>();
	public List<OpExtension> extensions = new ArrayList<>();
	public List<OpExtInstImport> instructionExtensions = new ArrayList<>();
	public OpMemoryModel opMemoryModel;
	public List<OpEntryPoint> entryPoints = new ArrayList<>();
	public List<ModeSettingInstruction> executionModes = new ArrayList<>();
	public List<Instruction> debugInformation = new ArrayList<>();
	public List<Instruction> debugNaming = new ArrayList<>();
	public List<OpModuleProcessed> moduleProcesses = new ArrayList<>();
	public List<AnnotationInstruction> annotations = new ArrayList<>();
	public List<TypeDeclarationInstruction> typeDeclarations = new ArrayList<>();
	public List<ConstantCreationInstruction> constantCreations = new ArrayList<>();
	public List<OpVariable> globalVariables = new ArrayList<>();
	public List<DebugInstruction> lineDebugInformation = new ArrayList<>();
	public List<SpirvFunction> functionDeclarations = new ArrayList<>();
	public List<SpirvFunction> functionDefinitions = new ArrayList<>();

	public SpirvModule(SpirvBinary spirvBinary) {
		List<Instruction> instructions = Arrays.asList(spirvBinary.instructions);

		AtomicInteger offset = new AtomicInteger();
		SpirvModule.into(this.capabilities, offset, instructions, OpCodes.OP_CAPABILITY);
		SpirvModule.into(this.extensions, offset, instructions, OpCodes.OP_EXTENSION);
		SpirvModule.into(this.instructionExtensions, offset, instructions, OpCodes.OP_EXT_INST_IMPORT);
		this.opMemoryModel = (OpMemoryModel) instructions.get(offset.getAndIncrement());
		SpirvModule.into(this.entryPoints, offset, instructions, OpCodes.OP_ENTRY_POINT);
		SpirvModule.into(this.executionModes, offset, instructions, OpCodes.OP_EXECUTION_MODE, OpCodes.OP_EXECUTION_MODE_ID);
		SpirvModule.into(this.debugInformation, offset, instructions, OpCodes.OP_STRING, OpCodes.OP_SOURCE_EXTENSION, OpCodes.OP_SOURCE, OpCodes.OP_SOURCE_CONTINUED);
		SpirvModule.into(this.debugNaming, offset, instructions, OpCodes.OP_NAME, OpCodes.OP_MEMBER_NAME);
		SpirvModule.into(this.moduleProcesses, offset, instructions, OpCodes.OP_MODULE_PROCESSED);
		SpirvModule.into(this.annotations, offset, instructions, inst -> inst instanceof AnnotationInstruction);

		for (int i = offset.get(), len = instructions.size(); i < len; i++) {
			Instruction instruction = instructions.get(i);
			if (instruction instanceof OpFunction) {
				offset.set(i);
				break;
			}

			if (instruction instanceof TypeDeclarationInstruction) {
				this.typeDeclarations.add((TypeDeclarationInstruction) instruction);
			} else if (instruction instanceof ConstantCreationInstruction) {
				this.constantCreations.add((ConstantCreationInstruction) instruction);
			} else if (instruction instanceof OpVariable) {
				OpVariable opVariable = (OpVariable) instruction;
				this.globalVariables.add(opVariable);
			} else if (instruction instanceof DebugInstruction) {
				this.lineDebugInformation.add((DebugInstruction) instruction);
			}
		}

		OpFunction function = null;
		List<OpFunctionParameter> parameterList = new ArrayList<>();
		List<Instruction> code = new ArrayList<>();

		for (int i = offset.get(), len = instructions.size(); i < len; i++) {
			Instruction instruction = instructions.get(i);

			if (instruction instanceof OpFunction) {
				function = (OpFunction) instruction;
			} else if (instruction instanceof OpFunctionEnd) {
				if (code.isEmpty()) {
					this.functionDeclarations.add(new SpirvFunction(function, parameterList, code, (OpFunctionEnd) instruction));
				} else {
					this.functionDefinitions.add(new SpirvFunction(function, parameterList, code, (OpFunctionEnd) instruction));
				}
				function = null;
				parameterList = new ArrayList<>();
				code = new ArrayList<>();
			} else if (instruction instanceof OpFunctionParameter) {
				parameterList.add((OpFunctionParameter) instruction);
			} else {
				code.add(instruction);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Instruction> void into(List<T> dst, AtomicInteger offset, List<Instruction> instructions, int... opcodes) {
		int i = offset.get();
		int size = instructions.size();
		start:
		while (i < size) {
			Instruction instruction = instructions.get(i);
			int instructionOpcode = instruction.opcode();
			for (int opcode : opcodes) {
				if (opcode == instructionOpcode) {
					dst.add((T) instruction);
					i++;
					continue start;
				}
			}
			break;
		}
		offset.set(i);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Instruction> void into(List<T> dst, AtomicInteger offset, List<Instruction> instructions, Function<Instruction, Boolean> predicate) {
		int i = offset.get();
		int size = instructions.size();
		while (i < size) {
			Instruction instruction = instructions.get(i);
			if (predicate.apply(instruction)) {
				dst.add((T) instruction);
			} else {
				break;
			}
			i++;
		}
		offset.set(i);
	}
}
