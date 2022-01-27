package com.consultadd.training.config;

import java.util.Optional;

import com.consultadd.training.Repository.EmployeeRepository;
import com.consultadd.training.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Employee employee=employeeRepository.findByUsername(userName);
       
       if (employee==null){
           throw new UsernameNotFoundException("Employee Not Found");
       }
        System.out.println(employee.getName());
        return new MyUserDetails(employee);
    }
    
}
