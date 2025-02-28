package com.example.my_rest_api.service;

import com.example.my_rest_api.model.EmployeDetails;
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
    public List<EmployeDetails> getAllEmployeeById() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeDetails getEmployeeById(Long employee_id) {
        return employeeRepository.findById(employee_id).orElse(null);
    }

    @Override
    public EmployeDetails saveEmployee(EmployeDetails employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeDetails updateEmployeeById(Long employee_id, EmployeDetails employee) {
        Optional<EmployeDetails> optionalEmployee = employeeRepository.findById(employee_id);
        if (optionalEmployee.isPresent()) {
            EmployeDetails updateEmployee = optionalEmployee.get();
            updateEmployee.setUsername(employee.getUsername());
            updateEmployee.setEmail_id(employee.getEmail_id());
            return employeeRepository.save(updateEmployee);
        }
        return null;
    }

    @Override
    public void deleteById(Long employee_id) {
       employeeRepository.deleteById(employee_id);
    }
}
