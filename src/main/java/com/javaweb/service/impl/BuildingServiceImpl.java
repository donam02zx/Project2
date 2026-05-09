package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingEntityConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentareaRepository;
import com.javaweb.repository.custom.impl.DistrictRepositoryImpl;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentareaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingResponse;
	
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	
	@Autowired
	private BuildingEntityConverter buildingEntityConverter;
	
	
	@Override
	public List<BuildingDTO> findAll(Map<String,Object> param, List<String> typeCode) {
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(param, typeCode);
		List<BuildingEntity> buildingEntities = buildingResponse.findAll(buildingSearchBuilder);
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
			result.add(building);
		}
		
		return result;
	}

	@Override
	public void updateOrInsertBuilding(BuildingRequestDTO buildingRequestDto) {
		//Không request id thì Insert ngc lại thì Update
		BuildingEntity building;
		if(buildingRequestDto.getId()==null) {
			building = new BuildingEntity();
		}else {
			building = buildingResponse.findById(buildingRequestDto.getId()).get();
		}
		building = buildingEntityConverter.toInsertOrUpdate(buildingRequestDto, building);
		buildingResponse.save(building);
	}

	@Override
	public void deleteBuilding(Long[] ids) {
		buildingResponse.deleteByIdIn(ids);
	}
	
	

}
