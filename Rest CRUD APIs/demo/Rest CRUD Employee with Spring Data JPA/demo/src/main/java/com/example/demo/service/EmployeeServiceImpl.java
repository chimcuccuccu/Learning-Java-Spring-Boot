package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
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
    public Optional<Employee> findById (int theId) {
        Optional<Employee> byId = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (byId.isPresent()) {
            theEmployee = byId.get();
        }
        return byId;
    }

    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    public void deleteById (int theId) {
        employeeRepository.deleteById(theId);
    }
}
