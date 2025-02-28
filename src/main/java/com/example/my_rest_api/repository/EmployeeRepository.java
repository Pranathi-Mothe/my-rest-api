package com.example.my_rest_api.repository;

import com.example.my_rest_api.model.EmployeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeDetails, Long> {
}
