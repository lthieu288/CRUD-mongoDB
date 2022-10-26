package com.example.demo.services.Impl;

import com.example.demo.data.models.Employee;
import com.example.demo.data.repositories.EmployeeRepository;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    @Override
    public List<Employee> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of((pageNo - 1)*pageSize, pageSize);
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.getContent();

        /*Query query = new Query();
        query.skip((long) (pageNo - 1) *pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Employee.class);*/
    }

    @Override
    public Employee findByIdEmployee(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeId(id);

        if(employeeOptional.isEmpty()){
            return null;
        }else{
            return employeeOptional.get();
        }

//        Query query = new Query();
//        query.fields().include("first_name").exclude("id");
//        query.addCriteria(Criteria.where("employee_ID").is(id));
//
//        return mongoTemplate.findOne(query, Employee.class);
    }

    @Override
    public Employee insertEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setEmployeeId(UUID.randomUUID().toString());

        return employeeRepository.save(employee);

//        Employee employee = modelMapper.map(employeeDto, Employee.class);
//        employee.setEmployeeId(UUID.randomUUID().toString());
//
//        return mongoTemplate.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeId(id);

        if(employeeOptional.isEmpty()){
            return null;
        }else{
            Employee employee = employeeOptional.get();
            modelMapper.map(employeeDto, employee);
            return employeeRepository.save(employee);
        }

//        Query query = new Query();
//        query.addCriteria(Criteria.where("employee_ID").is(id));
//
//        Document document = new Document();
//        mongoTemplate.getConverter().write(employeeDto, document);
//        Update update = fromDBObjectExcludeNullFields(document);
//        FindAndModifyOptions findAndModifyOptions = FindAndModifyOptions.options().returnNew(true);
//
//        return mongoTemplate.findAndModify(query, update, findAndModifyOptions, Employee.class);
    }

    @Override
    public Employee deleteEmployee(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeId(id);

        if(employeeOptional.isEmpty()){
            return null;
        }else{
            return employeeRepository.deleteByEmployeeId(id);
        }
    }

    public static Update fromDBObjectExcludeNullFields(Document object){
        Update update = new Update();
        for(String key : object.keySet()){
            Object value = object.get(key);
            if(value != null){
                update.set(key, value);
            }
        }
        return update;
    }


}
