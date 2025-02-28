package com.example.my_rest_api.service;


import com.example.my_rest_api.model.EmployeDetails;

import java.util.List;

public interface EmployeeService {

     List<EmployeDetails> getAllEmployeeById();
     EmployeDetails getEmployeeById(Long employee_id);
     EmployeDetails saveEmployee(EmployeDetails employee);
     EmployeDetails updateEmployeeById(Long employee_id, EmployeDetails employee);
     void deleteById(Long employee_id);
}
