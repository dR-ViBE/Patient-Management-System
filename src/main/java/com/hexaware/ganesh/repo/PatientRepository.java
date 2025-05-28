package com.hexaware.ganesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ganesh.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{

}
