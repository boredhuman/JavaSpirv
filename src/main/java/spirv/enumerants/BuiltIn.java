package spirv.enumerants;

import spirv.instructions.ValueEnum;

public enum BuiltIn implements ValueEnum {
	POSITION(0),
	POINT_SIZE(1),
	CLIP_DISTANCE(3),
	CULL_DISTANCE(4),
	VERTEX_ID(5),
	INSTANCE_ID(6),
	PRIMITIVE_ID(7),
	INVOCATION_ID(8),
	LAYER(9),
	VIEWPORT_INDEX(10),
	TESS_LEVEL_OUTER(11),
	TESS_LEVEL_INNER(12),
	TESS_COORD(13),
	PATCH_VERTICES(14),
	FRAG_COORD(15),
	POINT_COORD(16),
	FRONT_FACING(17),
	SAMPLE_ID(18),
	SAMPLE_POSITION(19),
	SAMPLE_MASK(20),
	FRAG_DEPTH(22),
	HELPER_INVOCATION(23),
	NUM_WORKGROUPS(24),
	WORKGROUP_SIZE(25),
	WORKGROUP_ID(26),
	LOCAL_INVOCATION_ID(27),
	GLOBAL_INVOCATION_ID(28),
	LOCAL_INVOCATION_INDEX(29),
	WORK_DIM(30),
	GLOBAL_SIZE(31),
	ENQUEUED_WORKGROUP_SIZE(32),
	GLOBAL_OFFSET(33),
	GLOBAL_LINEAR_ID(34),
	SUBGROUP_SIZE(36),
	SUBGROUP_MAX_SIZE(37),
	NUM_SUBGROUPS(38),
	NUM_ENQUEUED_SUBGROUPS(39),
	SUBGROUP_ID(40),
	SUBGROUP_LOCAL_INVOCATION_ID(41),
	VERTEX_INDEX(42),
	INSTANCE_INDEX(43),
	CORE_IDARM(4160),
	CORE_COUNT_ARM(4161),
	CORE_MAX_IDARM(4162),
	WARP_IDARM(4163),
	WARP_MAX_IDARM(4164),
	SUBGROUP_EQ_MASK(4416),
	SUBGROUP_GE_MASK(4417),
	SUBGROUP_GT_MASK(4418),
	SUBGROUP_LE_MASK(4419),
	SUBGROUP_LT_MASK(4420),
	BASE_VERTEX(4424),
	BASE_INSTANCE(4425),
	DRAW_INDEX(4426),
	PRIMITIVE_SHADING_RATE_KHR(4432),
	DEVICE_INDEX(4438),
	VIEW_INDEX(4440),
	SHADING_RATE_KHR(4444),
	TILE_OFFSET_QCOM(4492),
	TILE_DIMENSION_QCOM(4493),
	TILE_APRON_SIZE_QCOM(4494),
	BARY_COORD_NO_PERSP_AMD(4992),
	BARY_COORD_NO_PERSP_CENTROID_AMD(4993),
	BARY_COORD_NO_PERSP_SAMPLE_AMD(4994),
	BARY_COORD_SMOOTH_AMD(4995),
	BARY_COORD_SMOOTH_CENTROID_AMD(4996),
	BARY_COORD_SMOOTH_SAMPLE_AMD(4997),
	BARY_COORD_PULL_MODEL_AMD(4998),
	FRAG_STENCIL_REF_EXT(5014),
	REMAINING_RECURSION_LEVELS_AMDX(5021),
	SHADER_INDEX_AMDX(5073),
	VIEWPORT_MASK_NV(5253),
	SECONDARY_POSITION_NV(5257),
	SECONDARY_VIEWPORT_MASK_NV(5258),
	POSITION_PER_VIEW_NV(5261),
	VIEWPORT_MASK_PER_VIEW_NV(5262),
	FULLY_COVERED_EXT(5264),
	TASK_COUNT_NV(5274),
	PRIMITIVE_COUNT_NV(5275),
	PRIMITIVE_INDICES_NV(5276),
	CLIP_DISTANCE_PER_VIEW_NV(5277),
	CULL_DISTANCE_PER_VIEW_NV(5278),
	LAYER_PER_VIEW_NV(5279),
	MESH_VIEW_COUNT_NV(5280),
	MESH_VIEW_INDICES_NV(5281),
	BARY_COORD_KHR(5286),
	BARY_COORD_NO_PERSP_KHR(5287),
	FRAG_SIZE_EXT(5292),
	FRAG_INVOCATION_COUNT_EXT(5293),
	PRIMITIVE_POINT_INDICES_EXT(5294),
	PRIMITIVE_LINE_INDICES_EXT(5295),
	PRIMITIVE_TRIANGLE_INDICES_EXT(5296),
	CULL_PRIMITIVE_EXT(5299),
	LAUNCH_ID_KHR(5319),
	LAUNCH_SIZE_KHR(5320),
	WORLD_RAY_ORIGIN_KHR(5321),
	WORLD_RAY_DIRECTION_KHR(5322),
	OBJECT_RAY_ORIGIN_KHR(5323),
	OBJECT_RAY_DIRECTION_KHR(5324),
	RAY_TMIN_KHR(5325),
	RAY_TMAX_KHR(5326),
	INSTANCE_CUSTOM_INDEX_KHR(5327),
	OBJECT_TO_WORLD_KHR(5330),
	WORLD_TO_OBJECT_KHR(5331),
	HIT_TNV(5332),
	HIT_KIND_KHR(5333),
	CURRENT_RAY_TIME_NV(5334),
	HIT_TRIANGLE_VERTEX_POSITIONS_KHR(5335),
	HIT_MICRO_TRIANGLE_VERTEX_POSITIONS_NV(5337),
	HIT_MICRO_TRIANGLE_VERTEX_BARYCENTRICS_NV(5344),
	INCOMING_RAY_FLAGS_KHR(5351),
	RAY_GEOMETRY_INDEX_KHR(5352),
	HIT_IS_SPHERE_NV(5359),
	HIT_IS_LSSNV(5360),
	HIT_SPHERE_POSITION_NV(5361),
	WARPS_PER_SMNV(5374),
	SM_COUNT_NV(5375),
	WARP_IDNV(5376),
	SMIDNV(5377),
	HIT_LSS_POSITIONS_NV(5396),
	HIT_KIND_FRONT_FACING_MICRO_TRIANGLE_NV(5405),
	HIT_KIND_BACK_FACING_MICRO_TRIANGLE_NV(5406),
	HIT_SPHERE_RADIUS_NV(5420),
	HIT_LSS_RADII_NV(5421),
	CLUSTER_IDNV(5436),
	CULL_MASK_KHR(6021);

	public static final BuiltIn[] VALUES = BuiltIn.values();

	public final int value;

	BuiltIn(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public static BuiltIn get(int value) {
		switch (value) {
			case 0:
				return BuiltIn.POSITION;
			case 1:
				return BuiltIn.POINT_SIZE;
			case 3:
				return BuiltIn.CLIP_DISTANCE;
			case 4:
				return BuiltIn.CULL_DISTANCE;
			case 5:
				return BuiltIn.VERTEX_ID;
			case 6:
				return BuiltIn.INSTANCE_ID;
			case 7:
				return BuiltIn.PRIMITIVE_ID;
			case 8:
				return BuiltIn.INVOCATION_ID;
			case 9:
				return BuiltIn.LAYER;
			case 10:
				return BuiltIn.VIEWPORT_INDEX;
			case 11:
				return BuiltIn.TESS_LEVEL_OUTER;
			case 12:
				return BuiltIn.TESS_LEVEL_INNER;
			case 13:
				return BuiltIn.TESS_COORD;
			case 14:
				return BuiltIn.PATCH_VERTICES;
			case 15:
				return BuiltIn.FRAG_COORD;
			case 16:
				return BuiltIn.POINT_COORD;
			case 17:
				return BuiltIn.FRONT_FACING;
			case 18:
				return BuiltIn.SAMPLE_ID;
			case 19:
				return BuiltIn.SAMPLE_POSITION;
			case 20:
				return BuiltIn.SAMPLE_MASK;
			case 22:
				return BuiltIn.FRAG_DEPTH;
			case 23:
				return BuiltIn.HELPER_INVOCATION;
			case 24:
				return BuiltIn.NUM_WORKGROUPS;
			case 25:
				return BuiltIn.WORKGROUP_SIZE;
			case 26:
				return BuiltIn.WORKGROUP_ID;
			case 27:
				return BuiltIn.LOCAL_INVOCATION_ID;
			case 28:
				return BuiltIn.GLOBAL_INVOCATION_ID;
			case 29:
				return BuiltIn.LOCAL_INVOCATION_INDEX;
			case 30:
				return BuiltIn.WORK_DIM;
			case 31:
				return BuiltIn.GLOBAL_SIZE;
			case 32:
				return BuiltIn.ENQUEUED_WORKGROUP_SIZE;
			case 33:
				return BuiltIn.GLOBAL_OFFSET;
			case 34:
				return BuiltIn.GLOBAL_LINEAR_ID;
			case 36:
				return BuiltIn.SUBGROUP_SIZE;
			case 37:
				return BuiltIn.SUBGROUP_MAX_SIZE;
			case 38:
				return BuiltIn.NUM_SUBGROUPS;
			case 39:
				return BuiltIn.NUM_ENQUEUED_SUBGROUPS;
			case 40:
				return BuiltIn.SUBGROUP_ID;
			case 41:
				return BuiltIn.SUBGROUP_LOCAL_INVOCATION_ID;
			case 42:
				return BuiltIn.VERTEX_INDEX;
			case 43:
				return BuiltIn.INSTANCE_INDEX;
			case 4160:
				return BuiltIn.CORE_IDARM;
			case 4161:
				return BuiltIn.CORE_COUNT_ARM;
			case 4162:
				return BuiltIn.CORE_MAX_IDARM;
			case 4163:
				return BuiltIn.WARP_IDARM;
			case 4164:
				return BuiltIn.WARP_MAX_IDARM;
			case 4416:
				return BuiltIn.SUBGROUP_EQ_MASK;
			case 4417:
				return BuiltIn.SUBGROUP_GE_MASK;
			case 4418:
				return BuiltIn.SUBGROUP_GT_MASK;
			case 4419:
				return BuiltIn.SUBGROUP_LE_MASK;
			case 4420:
				return BuiltIn.SUBGROUP_LT_MASK;
			case 4424:
				return BuiltIn.BASE_VERTEX;
			case 4425:
				return BuiltIn.BASE_INSTANCE;
			case 4426:
				return BuiltIn.DRAW_INDEX;
			case 4432:
				return BuiltIn.PRIMITIVE_SHADING_RATE_KHR;
			case 4438:
				return BuiltIn.DEVICE_INDEX;
			case 4440:
				return BuiltIn.VIEW_INDEX;
			case 4444:
				return BuiltIn.SHADING_RATE_KHR;
			case 4492:
				return BuiltIn.TILE_OFFSET_QCOM;
			case 4493:
				return BuiltIn.TILE_DIMENSION_QCOM;
			case 4494:
				return BuiltIn.TILE_APRON_SIZE_QCOM;
			case 4992:
				return BuiltIn.BARY_COORD_NO_PERSP_AMD;
			case 4993:
				return BuiltIn.BARY_COORD_NO_PERSP_CENTROID_AMD;
			case 4994:
				return BuiltIn.BARY_COORD_NO_PERSP_SAMPLE_AMD;
			case 4995:
				return BuiltIn.BARY_COORD_SMOOTH_AMD;
			case 4996:
				return BuiltIn.BARY_COORD_SMOOTH_CENTROID_AMD;
			case 4997:
				return BuiltIn.BARY_COORD_SMOOTH_SAMPLE_AMD;
			case 4998:
				return BuiltIn.BARY_COORD_PULL_MODEL_AMD;
			case 5014:
				return BuiltIn.FRAG_STENCIL_REF_EXT;
			case 5021:
				return BuiltIn.REMAINING_RECURSION_LEVELS_AMDX;
			case 5073:
				return BuiltIn.SHADER_INDEX_AMDX;
			case 5253:
				return BuiltIn.VIEWPORT_MASK_NV;
			case 5257:
				return BuiltIn.SECONDARY_POSITION_NV;
			case 5258:
				return BuiltIn.SECONDARY_VIEWPORT_MASK_NV;
			case 5261:
				return BuiltIn.POSITION_PER_VIEW_NV;
			case 5262:
				return BuiltIn.VIEWPORT_MASK_PER_VIEW_NV;
			case 5264:
				return BuiltIn.FULLY_COVERED_EXT;
			case 5274:
				return BuiltIn.TASK_COUNT_NV;
			case 5275:
				return BuiltIn.PRIMITIVE_COUNT_NV;
			case 5276:
				return BuiltIn.PRIMITIVE_INDICES_NV;
			case 5277:
				return BuiltIn.CLIP_DISTANCE_PER_VIEW_NV;
			case 5278:
				return BuiltIn.CULL_DISTANCE_PER_VIEW_NV;
			case 5279:
				return BuiltIn.LAYER_PER_VIEW_NV;
			case 5280:
				return BuiltIn.MESH_VIEW_COUNT_NV;
			case 5281:
				return BuiltIn.MESH_VIEW_INDICES_NV;
			case 5286:
				return BuiltIn.BARY_COORD_KHR;
			case 5287:
				return BuiltIn.BARY_COORD_NO_PERSP_KHR;
			case 5292:
				return BuiltIn.FRAG_SIZE_EXT;
			case 5293:
				return BuiltIn.FRAG_INVOCATION_COUNT_EXT;
			case 5294:
				return BuiltIn.PRIMITIVE_POINT_INDICES_EXT;
			case 5295:
				return BuiltIn.PRIMITIVE_LINE_INDICES_EXT;
			case 5296:
				return BuiltIn.PRIMITIVE_TRIANGLE_INDICES_EXT;
			case 5299:
				return BuiltIn.CULL_PRIMITIVE_EXT;
			case 5319:
				return BuiltIn.LAUNCH_ID_KHR;
			case 5320:
				return BuiltIn.LAUNCH_SIZE_KHR;
			case 5321:
				return BuiltIn.WORLD_RAY_ORIGIN_KHR;
			case 5322:
				return BuiltIn.WORLD_RAY_DIRECTION_KHR;
			case 5323:
				return BuiltIn.OBJECT_RAY_ORIGIN_KHR;
			case 5324:
				return BuiltIn.OBJECT_RAY_DIRECTION_KHR;
			case 5325:
				return BuiltIn.RAY_TMIN_KHR;
			case 5326:
				return BuiltIn.RAY_TMAX_KHR;
			case 5327:
				return BuiltIn.INSTANCE_CUSTOM_INDEX_KHR;
			case 5330:
				return BuiltIn.OBJECT_TO_WORLD_KHR;
			case 5331:
				return BuiltIn.WORLD_TO_OBJECT_KHR;
			case 5332:
				return BuiltIn.HIT_TNV;
			case 5333:
				return BuiltIn.HIT_KIND_KHR;
			case 5334:
				return BuiltIn.CURRENT_RAY_TIME_NV;
			case 5335:
				return BuiltIn.HIT_TRIANGLE_VERTEX_POSITIONS_KHR;
			case 5337:
				return BuiltIn.HIT_MICRO_TRIANGLE_VERTEX_POSITIONS_NV;
			case 5344:
				return BuiltIn.HIT_MICRO_TRIANGLE_VERTEX_BARYCENTRICS_NV;
			case 5351:
				return BuiltIn.INCOMING_RAY_FLAGS_KHR;
			case 5352:
				return BuiltIn.RAY_GEOMETRY_INDEX_KHR;
			case 5359:
				return BuiltIn.HIT_IS_SPHERE_NV;
			case 5360:
				return BuiltIn.HIT_IS_LSSNV;
			case 5361:
				return BuiltIn.HIT_SPHERE_POSITION_NV;
			case 5374:
				return BuiltIn.WARPS_PER_SMNV;
			case 5375:
				return BuiltIn.SM_COUNT_NV;
			case 5376:
				return BuiltIn.WARP_IDNV;
			case 5377:
				return BuiltIn.SMIDNV;
			case 5396:
				return BuiltIn.HIT_LSS_POSITIONS_NV;
			case 5405:
				return BuiltIn.HIT_KIND_FRONT_FACING_MICRO_TRIANGLE_NV;
			case 5406:
				return BuiltIn.HIT_KIND_BACK_FACING_MICRO_TRIANGLE_NV;
			case 5420:
				return BuiltIn.HIT_SPHERE_RADIUS_NV;
			case 5421:
				return BuiltIn.HIT_LSS_RADII_NV;
			case 5436:
				return BuiltIn.CLUSTER_IDNV;
			case 6021:
				return BuiltIn.CULL_MASK_KHR;
			default:
				throw new RuntimeException(value + "does not map to a valid enum");
		}
	}
}