package com.employees.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@SequenceGenerator(name="employee_sequence", sequenceName="employee_sequence", allocationSize=1, initialValue=1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_sequence")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address; 
	
	@Column(name = "mobile_phone_number")
	private String mobilePhoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "organisation_id")
	private Organisation organisation;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String address, String mobilePhoneNumber,
			Organisation organisation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.organisation = organisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	
	
	
	

}
