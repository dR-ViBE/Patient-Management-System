package com.hexaware.ganesh.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name="id")
private String patientId;
	
	@Column(name="name")
private String patientName;

	@Column(name="patient_type")
private String type;
	
	@Column(name="gender")
private String gender;
	
	@Column(name="location")
private String location;
	
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Patient(String patientId, String patientName, String type, String gender, String location) 
{
	super();
	this.patientId = patientId;
	this.patientName = patientName;
	this.type = type;
	this.gender = gender;
	this.location = location;
}
public Patient() {
	super();
}
}
