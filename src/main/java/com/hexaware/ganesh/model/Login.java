package com.hexaware.ganesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
@Id
@Column(name="id")
	private String id;
@Column
private String password;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Login(String id, String password) {
	super();
	this.id = id;
	this.password = password;
}
public Login() {
	super();
}

	
	
}
