package com.luv2code.springboot.rest_crud_employee.rest;

import com.luv2code.springboot.rest_crud_employee.dao.EmployeeDAO;
import com.luv2code.springboot.rest_crud_employee.entity.Employee;
import com.luv2code.springboot.rest_crud_employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
    public Employee getEmployee (@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

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
        Employee dbEmployee = employeeService.findById(employeeId);

        if (dbEmployee == null) {
            throw new RuntimeException("Employee not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id " + employeeId;
    }
}
