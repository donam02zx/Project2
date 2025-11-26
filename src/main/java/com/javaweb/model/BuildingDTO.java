package com.javaweb.model;

import java.util.List;

public class BuildingDTO {
	private String namebuilding;
	private String address;
	private Integer numberofbasement;
	private String namemanager;
	private String numbermanager;
	private Integer floorarea;
	private Integer rentprice;
	private Integer servicefee;
	private List<Integer> rentarea;
	private List<String> renttype;
	
	public List<String> getRenttype() {
		return renttype;
	}
	public void setRenttype(List<String> renttype) {
		this.renttype = renttype;
	}
	public String getNamebuilding() {
		return namebuilding;
	}
	public void setNamebuilding(String namebuilding) {
		this.namebuilding = namebuilding;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
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
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	
	public Integer getServicefee() {
		return servicefee;
	}
	public void setServicefee(Integer servicefee) {
		this.servicefee = servicefee;
	}
	public List<Integer> getRentarea() {
		return rentarea;
	}
	public void setRentarea(List<Integer> rentarea) {
		this.rentarea = rentarea;
	}
	
	
	
}
