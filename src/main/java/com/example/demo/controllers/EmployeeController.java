package com.example.demo.controllers;

import com.example.demo.data.models.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees(
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize){
        List<Employee> EmployeeList = employeeService.findAll(pageNo, pageSize);
        if(EmployeeList.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll(pageNo, pageSize));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any employee in data");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id){

        Employee employee = employeeService.findByIdEmployee(id);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any employee have id: " + id);
        } else return ResponseEntity.ok(employee);
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.insertEmployee(employeeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable String id){
        Employee employee = employeeService.updateEmployee(id, employeeDto);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any employee have id: " + id);
        } else return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){
        Employee employee = employeeService.deleteEmployee(id);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any employee have id: " + id);
        }else{
            return ResponseEntity.ok(employee);
        }
    }
}
