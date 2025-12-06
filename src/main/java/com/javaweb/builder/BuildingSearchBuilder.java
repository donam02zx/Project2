package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private Long districtId;
	private String ward;
	private String street;
	private Long numberOfBasement;
	private String direction;
	private String level;
	private Long floorarea;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private String managername;
	private String managerphonenumber;
	private Long staffId;
	private List<String> typeCode = new ArrayList<String>();
	
	private BuildingSearchBuilder(Builder builder) {
		this.name=builder.name;
		this.rentAreaFrom=builder.rentAreaFrom;
		this.rentAreaTo=builder.rentAreaTo;
		this.districtId=builder.districtId;
		this.ward=builder.ward;
		this.street=builder.street;
		this.numberOfBasement=builder.numberOfBasement;
		this.direction=builder.direction;
		this.level=builder.level;
		this.floorarea=builder.floorarea;
		this.rentPriceFrom=builder.rentPriceFrom;
		this.rentPriceTo=builder.rentPriceTo;
		this.managername=builder.managername;
		this.managerphonenumber=builder.managerphonenumber;
		this.staffId=builder.staffId;
		this.typeCode=builder.typeCode;
	}
	
	public String getName() {
		return name;
	}
	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}
	public Long getRentAreaTo() {
		return rentAreaTo;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public String getNameManager() {
		return managername;
	}
	public String getNumberManeger() {
		return managerphonenumber;
	}
	public Long getStaffId() {
		return staffId;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	
	
	public static class Builder{
		private String name;
		private Long rentAreaFrom;
		private Long rentAreaTo;
		private Long districtId;
		private String ward;
		private String street;
		private Long numberOfBasement;
		private String direction;
		private String level;
		private Long floorarea;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private String managername;
		private String managerphonenumber;
		private Long staffId;
		private List<String> typeCode = new ArrayList<String>();
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setRentAreaFrom(Long rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Builder setRentAreaTo(Long rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		public Builder setFloorarea(Long floorarea) {
			this.floorarea = floorarea;
			return this;
		}
		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setNameManager(String nameManager) {
			this.managername = nameManager;
			return this;
		}
		public Builder setNumberManeger(String numberManeger) {
			this.managerphonenumber = numberManeger;
			return this;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
