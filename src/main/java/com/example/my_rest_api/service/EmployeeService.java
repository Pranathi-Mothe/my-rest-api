package com.example.my_rest_api.service;


import com.example.my_rest_api.model.EmployeDetails;

import java.util.List;

public interface EmployeeService {

     List<EmployeDetails> getAllEmployeeById();
     EmployeDetails getEmployeeById(Long employeeId);
     EmployeDetails saveEmployee(EmployeDetails employee);
     EmployeDetails updateEmployeeById(Long employeeId, EmployeDetails employee);
     void deleteById(Long employeeId);
}
