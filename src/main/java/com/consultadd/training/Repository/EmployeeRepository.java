package com.consultadd.training.Repository;

import com.consultadd.training.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> , CustomEmployeeRepository{
    
}
