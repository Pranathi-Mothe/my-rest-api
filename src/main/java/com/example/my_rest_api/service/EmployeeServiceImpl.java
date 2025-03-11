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
    public EmployeDetails getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public EmployeDetails saveEmployee(EmployeDetails employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeDetails updateEmployeeById(Long employeeId, EmployeDetails employee) {
        Optional<EmployeDetails> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            EmployeDetails updateEmployee = optionalEmployee.get();
            updateEmployee.setUserName(employee.getUserName());
            updateEmployee.setEmailId(employee.getEmailId());
            updateEmployee.setPhoneNumber(employee.getPhoneNumber());
            return employeeRepository.save(updateEmployee);
        }
        return null;
    }

    @Override
    public void deleteById(Long employeeId) {
       employeeRepository.deleteById(employeeId);
    }
}
