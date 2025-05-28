package com.hexaware.ganesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@Column(name="appointmentId")
	private String appointmentId;
	
	@Column(name="DoctorId")
	private String docId;
	
	@Column(name="PatientId")
	private String patId;
	
	@Column(name="DoctorName")
	private String docName;
	
	@Column(name="hospital")
	private String hospital;

	@Column(name="dateOfAppontment")
	private String dateofAppointment;
	
	@Column(name="status")
	private String status;

		

	public String getAppointmentId() {
		return appointmentId;
	}



	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}



	public String getDocId() {
		return docId;
	}



	public void setDocId(String docId) {
		this.docId = docId;
	}



	public String getPatId() {
		return patId;
	}



	public void setPatId(String patId) {
		this.patId = patId;
	}



	public String getDocName() {
		return docName;
	}



	public void setDocName(String docName) {
		this.docName = docName;
	}



	public String getHospital() {
		return hospital;
	}



	public void setHospital(String hospital) {
		this.hospital = hospital;
	}



	public String getDateofAppointment() {
		return dateofAppointment;
	}



	public void setDateofAppointment(String dateofAppointment) {
		this.dateofAppointment = dateofAppointment;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	

		public Appointment(String appointmentId, String docId, String patId, String docName, String hospital,
			String dateofAppointment, String status) {
		super();
		this.appointmentId = appointmentId;
		this.docId = docId;
		this.patId = patId;
		this.docName = docName;
		this.hospital = hospital;
		this.dateofAppointment = dateofAppointment;
		this.status = status;
	}



		public Appointment() {
			super();
		}
	
	
	




}
