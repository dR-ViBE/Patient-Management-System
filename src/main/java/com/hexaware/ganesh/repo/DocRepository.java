package com.hexaware.ganesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ganesh.model.Doctor;

@Repository
public interface DocRepository extends JpaRepository<Doctor,String> {

}
