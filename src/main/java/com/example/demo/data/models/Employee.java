package com.example.demo.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    @Field("employee_ID")
    private String employeeId;
    private List<String> acl;
    @Field("employee_compensation")
    private EmployeeCompensation employeeCompensation;
    @Field("employee_grade")
    private Integer employeeGrade;
    private String team;
    private Integer age;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private String gender;
    private String phone;
    private String address;
}

