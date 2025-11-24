package com.javaweb.model;

import java.util.List;

public class BuildingSearchRequest {
	private String nameBuilding;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private Integer districtId;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer floorarea;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private String nameManager;
	private String numberManeger;
	private Integer staffId;
	private List<String> rentType;
	
	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}
	public void setRentAreaFrom(Integer rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}
	public Integer getRentAreaTo() {
		return rentAreaTo;
	}
	public void setRentAreaTo(Integer rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}
	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(Integer rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public Integer getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(Integer rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
	
	
	public List<String> getRentType() {
		return rentType;
	}
	public void setRentType(List<String> rentType) {
		this.rentType = rentType;
	}
	public String getNameBuilding() {
		return nameBuilding;
	}
	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getNameManager() {
		return nameManager;
	}
	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
	}
	public String getNumberManeger() {
		return numberManeger;
	}
	public void setNumberManeger(String numberManeger) {
		this.numberManeger = numberManeger;
	}
	
	
}
