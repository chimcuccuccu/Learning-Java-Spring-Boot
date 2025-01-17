package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee (@PathVariable int employeeId) {
        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId) {
        Optional<Employee> dbEmployee = employeeService.findById(employeeId);

        if (dbEmployee.isEmpty()) {
            throw new RuntimeException("Employee not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id " + employeeId;
    }
}
