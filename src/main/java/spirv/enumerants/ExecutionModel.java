package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum ExecutionModel implements ValueEnum {
	VERTEX(0),
	TESSELLATION_CONTROL(1),
	TESSELLATION_EVALUATION(2),
	GEOMETRY(3),
	FRAGMENT(4),
	GL_COMPUTE(5),
	KERNEL(6),
	TASK_NV(5267),
	MESH_NV(5268),
	RAY_GENERATION_KHR(5313),
	INTERSECTION_KHR(5314),
	ANY_HIT_KHR(5315),
	CLOSEST_HIT_KHR(5316),
	MISS_KHR(5317),
	CALLABLE_KHR(5318),
	TASK_EXT(5364),
	MESH_EXT(5365);

	public static final ExecutionModel[] VALUES = ExecutionModel.values();

	public final int value;

	ExecutionModel(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static ExecutionModel get(int value) {
		switch (value) {
			case 0:
				return ExecutionModel.VERTEX;
			case 1:
				return ExecutionModel.TESSELLATION_CONTROL;
			case 2:
				return ExecutionModel.TESSELLATION_EVALUATION;
			case 3:
				return ExecutionModel.GEOMETRY;
			case 4:
				return ExecutionModel.FRAGMENT;
			case 5:
				return ExecutionModel.GL_COMPUTE;
			case 6:
				return ExecutionModel.KERNEL;
			case 5267:
				return ExecutionModel.TASK_NV;
			case 5268:
				return ExecutionModel.MESH_NV;
			case 5313:
				return ExecutionModel.RAY_GENERATION_KHR;
			case 5314:
				return ExecutionModel.INTERSECTION_KHR;
			case 5315:
				return ExecutionModel.ANY_HIT_KHR;
			case 5316:
				return ExecutionModel.CLOSEST_HIT_KHR;
			case 5317:
				return ExecutionModel.MISS_KHR;
			case 5318:
				return ExecutionModel.CALLABLE_KHR;
			case 5364:
				return ExecutionModel.TASK_EXT;
			case 5365:
				return ExecutionModel.MESH_EXT;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}