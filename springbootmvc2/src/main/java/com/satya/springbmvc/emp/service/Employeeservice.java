package com.satya.springbmvc.emp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satya.springbmvc.emp.entity.Employeeentity;
import com.satya.springbmvc.model.EmployeeModel;
import com.satya.springbmvc.repository.EmployeeRepository;


@Service
public class Employeeservice {
@Autowired
EmployeeRepository employeeRepository;

public void  saveEmployeeDetails(EmployeeModel employeeModel) 
{
	double hra;
	hra= 20/100 * employeeModel.getSalary();
	
    double da;
    da=25/100* employeeModel.getSalary();
    
    double finalsalary;
    finalsalary=da+hra;
    
	Employeeentity emp=new Employeeentity();
	emp.setName(employeeModel.getName());
	emp.setGender(employeeModel.getGender());
	emp.setPhno(employeeModel.getPhno());
	emp.setEmail(employeeModel.getEmail());
	emp.setSalary(employeeModel.getSalary());
	emp.setDepartment(employeeModel.getDepartment());
	emp.setFinalsalary(finalsalary);
	emp.setHra(hra);
	emp.setDa(da);
		
	employeeRepository.save(emp);
}
public List<Employeeentity>AllEmployees()
{
	List<Employeeentity>employee=employeeRepository.findAll();
	return employee;
}
public Employeeentity searchById(long id)
{
	Optional<Employeeentity>optionalData=employeeRepository.findById(id);
	if(optionalData.isPresent())
	{
		Employeeentity employee=optionalData.get();
		return employee;
	}
	else
	{
		return null;
	}
}
public void deleteemployeeById(long id) {
	employeeRepository.deleteById(id);
}

}
