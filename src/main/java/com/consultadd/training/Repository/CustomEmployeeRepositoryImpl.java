package com.consultadd.training.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.consultadd.training.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getCustomEmployee(){
        return entityManager.createQuery("SELECT e from Employee e ",Employee.class).getResultList();
    }


}
