package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum RayQueryIntersection implements ValueEnum {
	RAY_QUERY_CANDIDATE_INTERSECTION_KHR(0),
	RAY_QUERY_COMMITTED_INTERSECTION_KHR(1);

	public static final RayQueryIntersection[] VALUES = RayQueryIntersection.values();

	public final int value;

	RayQueryIntersection(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static RayQueryIntersection get(int value) {
		switch (value) {
			case 0:
				return RayQueryIntersection.RAY_QUERY_CANDIDATE_INTERSECTION_KHR;
			case 1:
				return RayQueryIntersection.RAY_QUERY_COMMITTED_INTERSECTION_KHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}