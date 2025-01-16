package com.luv2code.springboot.rest_crud_employee.service;

import com.luv2code.springboot.rest_crud_employee.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();
}
