package com.hexaware.ganesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ganesh.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}
