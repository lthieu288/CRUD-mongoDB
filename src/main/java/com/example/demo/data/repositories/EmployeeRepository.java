package com.example.demo.data.repositories;

import com.example.demo.data.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmployeeId(String id);
    Employee deleteByEmployeeId(String id);
}
