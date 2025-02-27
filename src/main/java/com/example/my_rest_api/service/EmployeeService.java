package com.example.my_rest_api.service;


import com.example.my_rest_api.model.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> getAllEmployeeById();
     Employee getEmployeeById(Long Id);
     Employee saveEmployee(Employee employee);
     Employee updateEmployeeById(Long Id, Employee employee);
     void deleteById(Long Id);
}
