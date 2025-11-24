package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingResponse;

	
	@Override
	public List<BuildingDTO> findAll(BuildingSearchRequest request) {
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		List<BuildingEntity> buildingEntities = buildingResponse.findAll(request);
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setNamebuilding(item.getNamebuilding());
			building.setAddress(item.getStreet()+","+item.getWard()+","+item.getDistrictname());
			building.setNumberofbasement(item.getNumberofbasement());
			building.setNamemanager(item.getNamemanager());
			building.setNumbermanager(item.getNumbermanager());
			building.setFloorarea(item.getFloorarea());
			building.setRentarea(item.getRentarea());
			building.setRentprice(item.getRentprice());
			building.setServicefee(item.getServicefee());
			building.setRentarea(item.getRentarea());
			result.add(building);
		}
		
		return result;
	}

}
