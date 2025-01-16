package com.luv2code.springboot.rest_crud_employee.dao;

import com.luv2code.springboot.rest_crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById (int theId);

    Employee save (Employee theEmployee);

    void deleteById (int theId);
}
