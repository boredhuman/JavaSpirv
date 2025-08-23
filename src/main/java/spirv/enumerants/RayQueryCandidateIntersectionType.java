package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum RayQueryCandidateIntersectionType implements ValueEnum {
	RAY_QUERY_CANDIDATE_INTERSECTION_TRIANGLE_KHR(0),
	RAY_QUERY_CANDIDATE_INTERSECTION_AABBKHR(1);

	public static final RayQueryCandidateIntersectionType[] VALUES = RayQueryCandidateIntersectionType.values();

	public final int value;

	RayQueryCandidateIntersectionType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static RayQueryCandidateIntersectionType get(int value) {
		switch (value) {
			case 0:
				return RayQueryCandidateIntersectionType.RAY_QUERY_CANDIDATE_INTERSECTION_TRIANGLE_KHR;
			case 1:
				return RayQueryCandidateIntersectionType.RAY_QUERY_CANDIDATE_INTERSECTION_AABBKHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}