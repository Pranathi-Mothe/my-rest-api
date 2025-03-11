package com.example.my_rest_api.controller;

import com.example.my_rest_api.model.EmployeDetails;
import com.example.my_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeDetails> getEmployeeById(@PathVariable Long employeeId){
        EmployeDetails employee = employeeService.getEmployeeById(employeeId);
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

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeDetails> updateEmployeeDetails(@PathVariable Long employeeId, @RequestBody EmployeDetails employeDetails){
       EmployeDetails details = employeeService.updateEmployeeById(employeeId, employeDetails);
        return details != null ? ResponseEntity.ok(details) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long employeeId){
         employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
