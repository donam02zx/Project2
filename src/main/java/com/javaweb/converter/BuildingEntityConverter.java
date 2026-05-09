package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentareaEntity;

@Component
public class BuildingEntityConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingEntity toInsertOrUpdate(BuildingRequestDTO buildingRequest, BuildingEntity building) {
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(buildingRequest, building);
		return building;
		
	}
}
