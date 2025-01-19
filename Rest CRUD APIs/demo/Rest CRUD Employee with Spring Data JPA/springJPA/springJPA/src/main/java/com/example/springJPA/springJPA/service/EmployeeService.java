package com.example.springJPA.springJPA.service;

import com.example.springJPA.springJPA.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById (int theId);

    Employee save (Employee theEmployee);

    void deletedById (int theId);
}
