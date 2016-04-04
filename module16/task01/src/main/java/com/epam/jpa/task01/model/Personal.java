package com.epam.jpa.task01.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "personal")
@NamedQuery(name = "personal.getAll", query = "SELECT p from Personal p")
public class Personal {
	
	private String id;
	private String driverLicense;
	private String eyecolor;
	private Employee employee;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "DLICENSE")
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	
	@Column(name = "EYECOLOR")
	public String getEyecolor() {
		return eyecolor;
	}
	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEEID")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
	
}
