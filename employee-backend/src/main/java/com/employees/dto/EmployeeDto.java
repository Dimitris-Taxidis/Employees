package com.employees.dto;

public class EmployeeDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String address; 
	
	private String mobilePhoneNumber;
	
	private OrganisationDto organisation;

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

	public OrganisationDto getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationDto organisation) {
		this.organisation = organisation;
	}
	
	

}
