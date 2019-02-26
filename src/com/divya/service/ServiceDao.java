package com.divya.service;

import com.divya.Pojo.Employee;

public interface ServiceDao {
	
	String insertEmpDetails(String empId, String empName, String empType, String deptname);
	String updateEmpDetails(String EmpId, String empType, String deptName);
	String deleteEmpDetails(String empId);
	Employee displayEmpDetails();
	//String departmentDetails();
}
