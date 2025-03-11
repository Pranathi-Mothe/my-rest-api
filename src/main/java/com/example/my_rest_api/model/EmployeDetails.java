package com.example.my_rest_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeDetails")
@Getter
@Setter
public class EmployeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  employeeId;
    public String userName;
    public String emailId;

    @Column(name = "phoneNumber")
    public  String phoneNumber;


}
