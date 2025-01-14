package com.satya.springbmvc.emp.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employeeentity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String Name;
	private int Phno;
	private char Gender;
	private double Salary;
	private double Hra;
	private double Da;
	private String Email;
	private String Department;
	private double Finalsalary;
	

}
