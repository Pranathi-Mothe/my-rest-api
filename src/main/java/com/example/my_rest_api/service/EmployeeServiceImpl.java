package com.example.my_rest_api.service;

import com.example.my_rest_api.model.Employee;
import com.example.my_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployeeById() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee updateEmployee = optionalEmployee.get();
            updateEmployee.setUsername(employee.getUsername());
            updateEmployee.setEmailid(employee.getEmailid());
            return employeeRepository.save(updateEmployee);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
       employeeRepository.deleteById(id);
    }
}
