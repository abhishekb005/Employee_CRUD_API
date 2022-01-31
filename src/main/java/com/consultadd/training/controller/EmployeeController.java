package com.consultadd.training.controller;
import com.consultadd.training.model.Employee;
import com.consultadd.training.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    
  //Retrieve List of All Employee
    @GetMapping("/getEmployee")
    public List<Employee> getEmployee(){
        //List<Employee> employeeList=
        return employeeService.getEmployee();
    }
    //Add Employee 
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    //Update Employee 
    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    //Delete Employee Using ID
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }
    
    @GetMapping("/createEmployee")
    public String addEmployee(){
        //List<Employee> employeeList=
        Employee emp=employeeService.createEmployee();
    return "Employee Created";
    }
    @GetMapping("/")
    public String home(){
        //List<Employee> employeeList=
        
    return "Hello Employee";
    }
    // @PatchMapping("/patchEmployee")
    // public Employee patchEmployee(@RequestBody Employee employee){
    //     return employeeService.patchEmployee(employee);
    // } 

}
