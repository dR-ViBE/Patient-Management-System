package com.hexaware.ganesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ganesh.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login,String>{

}
