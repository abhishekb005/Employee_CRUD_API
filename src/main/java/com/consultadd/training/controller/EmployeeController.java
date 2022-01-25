package com.consultadd.training.controller;
import com.consultadd.training.model.Employee;
import com.consultadd.training.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
  
    @GetMapping("/emp")
    public List<Employee> getEmployee(){
        //List<Employee> employeeList=
        return employeeService.getEmployee();
    }
    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(String id){
        return employeeService.deleteEmployee(id);
    }
    @PatchMapping("/patchEmployee")
    public Employee patchEmployee(@RequestBody Employee employee){
        return employeeService.patchEmployee(employee);
    } 
    @GetMapping("/custom")
    public List<Employee> getCustomEmployeeList(){
        return employeeService.getCustomEmployeeList();
    }
}
