package com.satya.springbmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.mvc.model.Productmodel;
import com.satya.springbmvc.emp.entity.Employeeentity;
import com.satya.springbmvc.emp.service.Employeeservice;
import com.satya.springbmvc.model.EmployeeModel;


@Controller
public class EmployeeController {
	@Autowired
	Employeeservice employeeservice;
	
	//get the data
@GetMapping("/Employeeform")
public String getEmployeeForm()
{
	return "add-Employee";
}
	//post the data
@PostMapping("/saveemployee")
public String saveEmployee(EmployeeModel employeemodel)
{
	employeeservice.saveEmployeeDetails(employeemodel);
	System.out.println(employeemodel);
	return "Empdone";
}
@GetMapping("/getAllemployees")
public String Allemployees(Model model) {
	List<Employeeentity>employees=employeeservice.AllEmployees();
	model.addAttribute("employees",employees);
	return "Employee-list";
	
}
@GetMapping("/getsearchform")
public String getsearchform() {
	return "search-employee";
}
@PostMapping("/searchbyid")
public String  searchById(@RequestParam long id,Model model) {
	Employeeentity employee=employeeservice.searchById(id);
	model.addAttribute("employee",employee);
	return "search-employee";
}
@GetMapping("/delete/{id}")
public String deleteemployeeById(@PathVariable("id")long Id) {
	employeeservice.deleteemployeeById(Id);
	return "redirect/getAllemployees";
}
@GetMapping("/edit/{id}")
public String editById(@PathVariable long id,Model model) 
{
	EmployeeModel employee=employeeservice.editById(id);
	model.addAttribute("employee",employee);
	model.addAttribute("id",id);
	return "edit-employee";
}
@PostMapping("/editemployeesave/{id}")
public String saveEditedemployee(@PathVariable long id,EmployeeModel employeemodel) 
{
	employeeservice.updateemployee(id,employeeservice);
	return "redirect:/getAllemployees";
}

}