package com.luv2code.springboot.rest_crud_employee.rest;

import com.luv2code.springboot.rest_crud_employee.dao.EmployeeDAO;
import com.luv2code.springboot.rest_crud_employee.entity.Employee;
import com.luv2code.springboot.rest_crud_employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
