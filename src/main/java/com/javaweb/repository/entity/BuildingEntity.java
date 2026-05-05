package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="numberofbasement")
	private Long numberofbasement;
	
	@Column(name="street")
	private String street;
	
	@Column(name="ward")
	private String ward;
	
//	@Column(name="districtid")
//	private Long districtid;
	
	@Column(name="floorarea")
	private Long floorarea;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="level")
	private String level;
	
	@Column(name="rentprice")
	private Long rentprice;
	
	@Column(name="namemanager")
	private String namemanager;
	
	@Column(name="numbermanager")
	private String numbermanager;
	
	@Column(name="servicefee")
	private Long servicefee;
	
	@ManyToOne
	@JoinColumn(name="districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentareaEntity> items = new ArrayList<>();
	
	
	
	public List<RentareaEntity> getItems() {
		return items;
	}
	public void setItems(List<RentareaEntity> items) {
		this.items = items;
	}
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
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
//	public Long getDistrictid() {
//		return districtid;
//	}
//	public void setDistrictid(Long districtid) {
//		this.districtid = districtid;
//	}
	public Long getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Long floorarea) {
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
	public Long getRentprice() {
		return rentprice;
	}
	public void setRentprice(Long rentprice) {
		this.rentprice = rentprice;
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
	public Long getServicefee() {
		return servicefee;
	}
	public void setServicefee(Long servicefee) {
		this.servicefee = servicefee;
	}
	
}
