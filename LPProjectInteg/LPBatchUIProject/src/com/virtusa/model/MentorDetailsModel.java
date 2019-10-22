package com.virtusa.model;

public class MentorDetailsModel {

	private String firstName;
	private String lastName;
	private String mentorid;
	private String email;
	private int phonenumber;
	private String batchname;
	
	public String getMentorid() {
		return mentorid;
	}

	public void setMentorid(String mentorid) {
		this.mentorid = mentorid;
	}

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
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

	@Override
	public String toString() {
		return "MentorDetailsModel [firstName=" + firstName + ", lastName=" + lastName + ", mentorid=" + mentorid
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", batchname=" + batchname + "]";
	}
	
}
