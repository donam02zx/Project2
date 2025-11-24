package com.javaweb.repository.entity;

import java.util.List;

public class BuildingEntity {
	private String namebuilding;
	private Integer numberofbasement;
	private String street;
	private String ward;
	private Integer districtid;
	private String districtname;
	private Integer floorarea;
	private String direction;
	private String level;
	private Integer rentprice;
	private List<Integer> rentarea;
	private String namemanager;
	private String numbermanager;
	private List<String> renttype;
	private Integer startid;
	private Integer servicefee;
	
	
	public Integer getServicefee() {
		return servicefee;
	}
	public void setServicefee(Integer servicefee) {
		this.servicefee = servicefee;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	
	public List<Integer> getRentarea() {
		return rentarea;
	}
	public void setRentarea(List<Integer> rentarea) {
		this.rentarea = rentarea;
	}
	public String getNamebuilding() {
		return namebuilding;
	}
	public void setNamebuilding(String namebuilding) {
		this.namebuilding = namebuilding;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}
	
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
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
	public String getNamemanager() {
		return namemanager;
	}
	public void setNamemanager(String namemanager) {
		this.namemanager = namemanager;
	}
	public String getNumbermanager() {
		return numbermanager;
	}
	public void setNumbermanager(String numbermanager) {
		this.numbermanager = numbermanager;
	}
	
	
	
	public List<String> getRenttype() {
		return renttype;
	}
	public void setRenttype(List<String> renttype) {
		this.renttype = renttype;
	}
	public Integer getStartid() {
		return startid;
	}
	public void setStartid(Integer startid) {
		this.startid = startid;
	}
	
	
	
}
