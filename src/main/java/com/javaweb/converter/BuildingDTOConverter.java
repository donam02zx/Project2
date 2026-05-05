package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentareaEntity;

@Component
public class BuildingDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		//DistrictEntity districtEntity = districtResponse.findNameById(item.getDistrictid());
		building.setAddress(item.getStreet()+","+item.getWard()+","+item.getDistrict().getName());
		List<RentareaEntity> listRentArea = item.getItems();
		String areaRentResult = listRentArea.stream().map(it->it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentarea(areaRentResult);
//		building.setRentprice(item.getRentprice());
//		building.setServicefee(item.getServicefee());
//		building.setNumberofbasement(item.getNumberofbasement());
//		building.setNamemanager(item.getNamemanager());
//		building.setNumbermanager(item.getNumbermanager());
//		building.setFloorarea(item.getFloorarea());
//		building.setNamebuilding(item.getName());
		return building;
	}

}
