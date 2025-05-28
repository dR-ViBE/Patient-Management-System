package com.hexaware.ganesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@Column(name="id")
	private String docId;
	
	@Column(name = "doc_name")
	private String docName;
	
	@Column(name = "department")

	private String department;

	@Column(name = "fees")
	private float fees;
	
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public Doctor(String docId, String docName, String department, float fees) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.department = department;
		this.fees = fees;
	}
	public Doctor() {
		super();
	}
	
}
