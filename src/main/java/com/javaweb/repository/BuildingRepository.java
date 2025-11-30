package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String,Object> param, List<String> typeCode);
}
