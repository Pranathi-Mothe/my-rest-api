package com.example.my_rest_api.controller;

import com.example.my_rest_api.model.EmployeDetails;
import com.example.my_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeDetails> getEmployeeById(@PathVariable Long employee_id){
        EmployeDetails employee = employeeService.getEmployeeById(employee_id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeDetails>> getEmployeeDetails(){
        return ResponseEntity.ok(employeeService.getAllEmployeeById());
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeDetails> saveEmployee(@RequestBody EmployeDetails employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{employee_id}")
    public ResponseEntity<EmployeDetails> updateEmployeeDetails(@PathVariable Long employee_id, @RequestBody EmployeDetails employeDetails){
       EmployeDetails details = employeeService.updateEmployeeById(employee_id, employeDetails);
        return details != null ? ResponseEntity.ok(details) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long employee_id){
         employeeService.deleteById(employee_id);
        return ResponseEntity.noContent().build();
    }
}
