package com.consultadd.training.controller;
import com.consultadd.training.jwt.JwtUtil;
import com.consultadd.training.model.AuthenticationRequest;
import com.consultadd.training.model.AuthenticationResponse;
import com.consultadd.training.model.Employee;
import com.consultadd.training.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

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
    
    @RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            //TODO: handle exception
            throw new Exception("Incorrect Username or password",e);
        }
        final String jwt=jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    // @PatchMapping("/patchEmployee")
    // public Employee patchEmployee(@RequestBody Employee employee){
    //     return employeeService.patchEmployee(employee);
    // } 

}
