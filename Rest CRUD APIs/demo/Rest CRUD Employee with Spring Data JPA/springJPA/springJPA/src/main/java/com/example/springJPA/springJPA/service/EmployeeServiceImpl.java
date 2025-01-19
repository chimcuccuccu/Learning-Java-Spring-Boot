package com.example.springJPA.springJPA.service;

import com.example.springJPA.springJPA.dao.EmployeeRepository;
import com.example.springJPA.springJPA.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> byId = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (byId.isPresent()) {
            theEmployee = byId.get();
        }
        else {
            throw new RuntimeException("Did not find the id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deletedById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
