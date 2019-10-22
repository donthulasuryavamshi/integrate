package com.virtusa.model;

import java.time.LocalDate;
import java.util.Date;

public class LPRegistrationModel {
	private String lpId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    //private LocalDate dob;
    private String email;
    private String role;
    private String city;
    private String state;
    private String country;
	public String getLpId() {
		return lpId;
	}
	public void setLpId(String lpId) {
		this.lpId = lpId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	// LocalDate getDob() {
	//	return dob;
	//}
	//public void setDob(LocalDate dob) {
		//this.dob = dob;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "LPRegistrationModel [lpId=" + lpId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber +  ", email=" + email + ", designation=" + role
				+ ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
    
	
}
