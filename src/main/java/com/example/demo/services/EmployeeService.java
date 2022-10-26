package com.example.demo.services;

import com.example.demo.data.models.Employee;
import com.example.demo.dto.EmployeeDto;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll(int pageNo, int pageSize);
    Employee findByIdEmployee(String id);
    Employee insertEmployee(EmployeeDto employeeDto);
    Employee updateEmployee(String id, EmployeeDto employeeDto);
    Employee deleteEmployee(String id);
}
