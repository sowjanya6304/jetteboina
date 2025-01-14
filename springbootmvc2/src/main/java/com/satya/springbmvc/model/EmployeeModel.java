package com.satya.springbmvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	
	private String Name;
	private int Phno;
	private char Gender;
	private double Salary;
	private String Email;
	private String Department;

}
