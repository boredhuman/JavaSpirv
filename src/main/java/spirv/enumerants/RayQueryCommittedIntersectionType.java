package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum RayQueryCommittedIntersectionType implements ValueEnum {
	RAY_QUERY_COMMITTED_INTERSECTION_NONE_KHR(0),
	RAY_QUERY_COMMITTED_INTERSECTION_TRIANGLE_KHR(1),
	RAY_QUERY_COMMITTED_INTERSECTION_GENERATED_KHR(2);

	public static final RayQueryCommittedIntersectionType[] VALUES = RayQueryCommittedIntersectionType.values();

	public final int value;

	RayQueryCommittedIntersectionType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static RayQueryCommittedIntersectionType get(int value) {
		switch (value) {
			case 0:
				return RayQueryCommittedIntersectionType.RAY_QUERY_COMMITTED_INTERSECTION_NONE_KHR;
			case 1:
				return RayQueryCommittedIntersectionType.RAY_QUERY_COMMITTED_INTERSECTION_TRIANGLE_KHR;
			case 2:
				return RayQueryCommittedIntersectionType.RAY_QUERY_COMMITTED_INTERSECTION_GENERATED_KHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}