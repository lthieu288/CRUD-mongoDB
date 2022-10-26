package com.example.demo.dto;

import com.example.demo.data.models.EmployeeCompensation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private List<String> acl;
    private EmployeeCompensation employeeCompensation;
    private Integer employeeGrade;
    private String team;
    private Integer age;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String address;
}
