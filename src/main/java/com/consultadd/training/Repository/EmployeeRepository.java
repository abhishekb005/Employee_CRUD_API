package com.consultadd.training.Repository;

import java.util.Optional;

import com.consultadd.training.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    @Query("Select e from Employee e where username= :Username")
    Employee findByUsername(@Param("Username") String Username);
}
