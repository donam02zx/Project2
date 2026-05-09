package com.javaweb.api;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexceptions.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.BuildingService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@RestController
@Transactional
@PropertySource("classpath:application.properties")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingResponse;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Value("${dev.do}")
	private String data;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,Object> param,
										 @RequestParam(name="typeCode", required = false) List<String> typeCode){
		List<BuildingDTO> result = buildingResponse.findAll(param,typeCode);
		return result;
	}
	
	@GetMapping(value="/api/building/{name}")
	public BuildingDTO getBuildingbyId(@PathVariable String name) {
		BuildingDTO result = new BuildingDTO();
		List<BuildingEntity> building = buildingRepository.findByNameContaining(name);
		return result;
	}
	
	@PostMapping(value="/api/building/")
	public void creatBuilding(@RequestBody BuildingRequestDTO buildingRequest) {
		buildingResponse.updateOrInsertBuilding(buildingRequest);
	}
	
	@PutMapping(value="/api/building/{id}")
	public void updateBuilding(@PathVariable Long id, @RequestBody BuildingRequestDTO buildingRequest) {
		buildingRequest.setId(id);
		buildingResponse.updateOrInsertBuilding(buildingRequest);
	}
	
	@DeleteMapping(value="/api/building/{ids}")
	public void deleteBuilding(@PathVariable Long[] ids) {
		buildingResponse.deleteBuilding(ids);
	}
//	@PostMapping(value="/api/building/")
//	public void creatBuilding(@RequestBody BuildingRequestDTO buildingRequest) {
//		BuildingEntity building = new BuildingEntity();
//		DistrictEntity district = new DistrictEntity();
//		building.setName(buildingRequest.getName());
//		building.setStreet(buildingRequest.getStreet());
//		building.setWard(buildingRequest.getWard());
//		district.setId(buildingRequest.getDistrictId());
//		building.setDistrict(district);
//		entityManager.persist(building);
//		System.out.println("ok");
//	}
//	
//	@PutMapping(value="/api/building/")
//	public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequest) {
//		BuildingEntity building = buildingRepository.findById(buildingRequest.getId()).get();
//		building.setName(buildingRequest.getName());
//		building.setWard(buildingRequest.getWard());
//		building.setStreet(buildingRequest.getStreet());
//		DistrictEntity districtEntity = new DistrictEntity();
//		districtEntity.setId(buildingRequest.getDistrictId());
//		building.setDistrict(districtEntity);
//		buildingRepository.save(building);
//		System.out.println("oke");
//	}
	
//	@DeleteMapping(value="/api/building/{id}")
//	public void deleteBuilding(@PathVariable Long id) {
//		BuildingEntity building = entityManager.find(BuildingEntity.class, id);
//		entityManager.remove(building);
//		System.out.println(data);
//	}
	
//	@DeleteMapping(value="/api/building/{ids}")
//	public void deleteBuildingByStringDataJPA(@PathVariable Long[] ids) {
//		buildingRepository.deleteByIdIn(ids);
//	}
	
	
	
}
