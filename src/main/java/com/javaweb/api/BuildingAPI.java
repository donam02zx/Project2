package com.javaweb.api;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexceptions.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@RestController
public class BuildingAPI {
//	@GetMapping(value="/api/building/")
//	public Object getBuilding(@RequestParam(value="name", required=false) String name,
//							@RequestParam(value="numberOfBasement", required=false) String num,
//							@RequestParam(value="street", required=false) String street) {
//		try {
//			System.out.print(5/0);
//		} catch (Exception e) {
//			ErrorResponseDTO errDTO = new ErrorResponseDTO();
//			errDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("Khong the chia so nguyen cho 0");
//			errDTO.setDetails(details);
//			return errDTO;
//		}
//		List<BuildingDTO> listBuiding = new ArrayList<>();
//		BuildingDTO buidingDTO1 = new BuildingDTO();
//		buidingDTO1.setName("buiding 1");
//		buidingDTO1.setNumberOfBasement("1");
//		buidingDTO1.setStreet("hoang van thu");
//		BuildingDTO buidingDTO2 = new BuildingDTO();
//		buidingDTO2.setName("buiding 2");
//		buidingDTO2.setNumberOfBasement("2");
//		buidingDTO2.setStreet("cmt8");
//		listBuiding.add(buidingDTO1);
//		listBuiding.add(buidingDTO2);
//		return listBuiding;
//		
//	}
	
	@Autowired
	private BuildingService buildingResponse;
	
	
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,Object> param,
										 @RequestParam(name="typeCode", required = false) List<String> typeCode){
		List<BuildingDTO> result = buildingResponse.findAll(param,typeCode);
		return result;
	}
	
	
	
	
//	@PostMapping(value="/api/building/")
//	public Object postBuilding(@RequestBody BuildingDTO buildingDto) {
//		valid(buildingDto);
//		
//		return buildingDto;
//	}
//	
//	public void valid(BuildingDTO buildingDto) {
//		if(buildingDto.getName()==null||buildingDto.getNumberOfBasement()==null) {
//			throw new FieldRequiredException("name or numberofbasement is null");
//		}
//	}
}
