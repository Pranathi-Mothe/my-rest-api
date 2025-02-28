package com.example.my_rest_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employe_details")
@Getter
@Setter
public class EmployeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long employee_id;
    public String username;
    public String email_id;


}
