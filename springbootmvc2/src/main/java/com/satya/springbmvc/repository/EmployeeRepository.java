package com.satya.springbmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.satya.springbmvc.emp.entity.Employeeentity;
@Repository
public interface EmployeeRepository extends JpaRepository<Employeeentity, Long>{

}
