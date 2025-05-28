package com.hexaware.ganesh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ganesh.model.Appointment;
import com.hexaware.ganesh.model.Doctor;
import com.hexaware.ganesh.model.Login;
import com.hexaware.ganesh.model.Patient;
import com.hexaware.ganesh.repo.AppointmentRepository;
import com.hexaware.ganesh.repo.DocRepository;
import com.hexaware.ganesh.repo.LoginRepository;
import com.hexaware.ganesh.repo.PatientRepository;


import com.hexaware.ganesh.exception.ResourceNotFoundException;




@RestController
@RequestMapping("/healthcare/")
@CrossOrigin(origins="http://localhost:3000")
public class Controller {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DocRepository docRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@GetMapping("/health")
	public String health() {
	  return "Health check";
	}

	@GetMapping("/view-patient")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/view-doctor")
	public List<Doctor> getAllDoctors(){
		return docRepository.findAll();
	}
	
	@PostMapping("/register")
	public Login register(@RequestBody Login login) {
		return loginRepository.save(login);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		Login loginDetails = loginRepository.findById(login.getId()).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + login.getId()));
		System.out.println(login.getId()+login.getPassword());
		if(login.getId().equals(loginDetails.getId()) && login.getPassword().equals(loginDetails.getPassword()))
		{
			System.out.println("OK");
			return new ResponseEntity<>("OK",HttpStatus.OK);
		
		}
		else
			return new ResponseEntity<>("Not Accesible",HttpStatus.OK);
		
	}
	
	@PostMapping("/doctorprofile")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return docRepository.save(doctor);
	}
	
	@PostMapping("/patientprofile")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@GetMapping("/patientid/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
		Patient patient= patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(patient);
	}
	
	@GetMapping("/doctorid/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
		Doctor doctor= docRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(doctor);
	}
	
	@GetMapping("/appointmentid/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
		Appointment app= appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(app);
	}

	@PutMapping("/doctor-update/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody Doctor doctorDetails){
		Doctor doctor = docRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		doctor.setDepartment(doctorDetails.getDepartment());
		doctor.setFees(doctorDetails.getFees());
		doctor.setDocName(doctorDetails.getDocName());
		
		Doctor updatedDoctor = docRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	@PutMapping("/patient-update/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patientDetails){
		Patient patient= patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		patient.setGender(patientDetails.getGender());
		patient.setLocation(patientDetails.getLocation());
		patient.setPatientName(patientDetails.getPatientName());
		patient.setType(patientDetails.getType());


		
		Patient updatedPatient= patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	@PutMapping("/appointment-update/{id}/{status}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable String id,@PathVariable String status){
		Appointment app = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		app.setStatus(status);
		
		
		Appointment updated = appointmentRepository.save(app);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable String id){
		Patient patient= patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/appointment")
	public Appointment requestAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
}
