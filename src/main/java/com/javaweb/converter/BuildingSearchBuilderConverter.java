package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.Utils.MapUtil;
import com.javaweb.builder.BuildingSearchBuilder;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> param,List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
																		.setName(MapUtil.getObject(param, "name", String.class))
																		.setRentAreaFrom(MapUtil.getObject(param, "rentAreaFrom", Long.class))
																		.setRentAreaTo(MapUtil.getObject(param, "rentAreaTo", Long.class))
																		.setDistrictId(MapUtil.getObject(param, "districtid", Long.class))
																		.setWard(MapUtil.getObject(param, "ward", String.class))
																		.setStreet(MapUtil.getObject(param, "street", String.class))
																		.setNumberOfBasement(MapUtil.getObject(param, "numberofbasement", Long.class))
																		.setDirection(MapUtil.getObject(param, "direction", String.class))
																		.setLevel(MapUtil.getObject(param, "level", String.class))
																		.setFloorarea(MapUtil.getObject(param, "floorarea", Long.class))
																		.setRentPriceFrom(MapUtil.getObject(param, "rentPriceFrom", Long.class))
																		.setRentPriceTo(MapUtil.getObject(param, "rentPriceTo", Long.class))
																		.setNameManager(MapUtil.getObject(param, "managername", String.class))
																		.setNumberManeger(MapUtil.getObject(param, "managerphonenumber", String.class))
																		.setStaffId(MapUtil.getObject(param, "staffId", Long.class))
																		.setTypeCode(typeCode)
																		.build();
																																
		return buildingSearchBuilder;																
	}
}
