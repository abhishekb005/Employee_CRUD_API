package com.consultadd.training.service;

import java.util.List;

import com.consultadd.training.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consultadd.training.model.*;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    
    public List<Employee> getEmployee(){
        List<Employee> employeeList=employeeRepository.findAll();
        System.out.println(employeeRepository.getClass());
        return employeeList;
    }

    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "Employee already Exist";
        }
        employeeRepository.save(employee);
        return "Employee Info Saved Succesfully";
    }

    public String updateEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.save(employee);
            return "Employee Updated";
        }
        return "Employee Not Found";
    }
    
    public String deleteEmployee(String id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "Employee Deleted ";
        }
        return "Employee Not Found";
    }
    public Employee createEmployee(){
        //employeeRepository.
        Employee employee=new Employee("2", "abhi2", "pass", "ADMIN", true, "abhishek", 22);
        employeeRepository.save(employee);
        return employee;
    }
}

