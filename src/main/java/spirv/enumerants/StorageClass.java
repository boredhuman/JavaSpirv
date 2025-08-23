package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum StorageClass implements ValueEnum {
	UNIFORM_CONSTANT(0),
	INPUT(1),
	UNIFORM(2),
	OUTPUT(3),
	WORKGROUP(4),
	CROSS_WORKGROUP(5),
	PRIVATE(6),
	FUNCTION(7),
	GENERIC(8),
	PUSH_CONSTANT(9),
	ATOMIC_COUNTER(10),
	IMAGE(11),
	STORAGE_BUFFER(12),
	TILE_IMAGE_EXT(4172),
	TILE_ATTACHMENT_QCOM(4491),
	NODE_PAYLOAD_AMDX(5068),
	CALLABLE_DATA_KHR(5328),
	INCOMING_CALLABLE_DATA_KHR(5329),
	RAY_PAYLOAD_KHR(5338),
	HIT_ATTRIBUTE_KHR(5339),
	INCOMING_RAY_PAYLOAD_KHR(5342),
	SHADER_RECORD_BUFFER_KHR(5343),
	PHYSICAL_STORAGE_BUFFER(5349),
	HIT_OBJECT_ATTRIBUTE_NV(5385),
	TASK_PAYLOAD_WORKGROUP_EXT(5402),
	CODE_SECTION_INTEL(5605),
	DEVICE_ONLY_INTEL(5936),
	HOST_ONLY_INTEL(5937);

	public static final StorageClass[] VALUES = StorageClass.values();

	public final int value;

	StorageClass(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static StorageClass get(int value) {
		switch (value) {
			case 0:
				return StorageClass.UNIFORM_CONSTANT;
			case 1:
				return StorageClass.INPUT;
			case 2:
				return StorageClass.UNIFORM;
			case 3:
				return StorageClass.OUTPUT;
			case 4:
				return StorageClass.WORKGROUP;
			case 5:
				return StorageClass.CROSS_WORKGROUP;
			case 6:
				return StorageClass.PRIVATE;
			case 7:
				return StorageClass.FUNCTION;
			case 8:
				return StorageClass.GENERIC;
			case 9:
				return StorageClass.PUSH_CONSTANT;
			case 10:
				return StorageClass.ATOMIC_COUNTER;
			case 11:
				return StorageClass.IMAGE;
			case 12:
				return StorageClass.STORAGE_BUFFER;
			case 4172:
				return StorageClass.TILE_IMAGE_EXT;
			case 4491:
				return StorageClass.TILE_ATTACHMENT_QCOM;
			case 5068:
				return StorageClass.NODE_PAYLOAD_AMDX;
			case 5328:
				return StorageClass.CALLABLE_DATA_KHR;
			case 5329:
				return StorageClass.INCOMING_CALLABLE_DATA_KHR;
			case 5338:
				return StorageClass.RAY_PAYLOAD_KHR;
			case 5339:
				return StorageClass.HIT_ATTRIBUTE_KHR;
			case 5342:
				return StorageClass.INCOMING_RAY_PAYLOAD_KHR;
			case 5343:
				return StorageClass.SHADER_RECORD_BUFFER_KHR;
			case 5349:
				return StorageClass.PHYSICAL_STORAGE_BUFFER;
			case 5385:
				return StorageClass.HIT_OBJECT_ATTRIBUTE_NV;
			case 5402:
				return StorageClass.TASK_PAYLOAD_WORKGROUP_EXT;
			case 5605:
				return StorageClass.CODE_SECTION_INTEL;
			case 5936:
				return StorageClass.DEVICE_ONLY_INTEL;
			case 5937:
				return StorageClass.HOST_ONLY_INTEL;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}