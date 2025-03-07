package com.example.springJPA.springJPA.rest;

import com.example.springJPA.springJPA.entity.Employee;
import com.example.springJPA.springJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee getEmployee (@PathVariable int theId) {
        Employee theEmployee = employeeService.findById(theId);

        if (theEmployee == null) {
            throw new RuntimeException ("Employee not found: " + theId);
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
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deletedById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
