package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class EmployeeCompensation {

    private List<String> acl;
    private Integer salary;
    @Field("stock_award")
    private Integer stockAward;
    @Field("programs")
    private Programs programs;
}
