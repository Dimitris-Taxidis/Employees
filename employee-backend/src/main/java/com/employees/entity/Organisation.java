package com.employees.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="organisation")
public class Organisation {
	
	@Id
	@SequenceGenerator(name="organisation_sequence", sequenceName="organisation_sequence", allocationSize=1, initialValue=1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="organisation_sequence")
	@Column(name = "id")
	private Long id;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "business_registration_number")
	private String businessRegistrationNumber;
	
	@Column(name = "address")
	private String address;

	public Organisation() {
		super();
	}
	
	

	public Organisation(String name, String businessRegistrationNumber, String address) {
		super();
		this.name = name;
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.address = address;
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

	public String getBusinessRegistrationNumber() {
		return businessRegistrationNumber;
	}

	public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
		this.businessRegistrationNumber = businessRegistrationNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
			
	
}
