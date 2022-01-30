package com.consultadd.training.config;

import java.util.Collection;
import java.util.List;

import com.consultadd.training.model.Employee;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails implements UserDetails{
    String ROLE_PREFIX = "ROLE_";
    private Employee employee;

    public MyUserDetails(Employee employee) {
        this.employee=employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(ROLE_PREFIX + employee.getRole());
        System.out.println(employee.getRole());
        System.out.println(List.of(simpleGrantedAuthority).toString());
        return List.of(simpleGrantedAuthority);   
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return employee.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
