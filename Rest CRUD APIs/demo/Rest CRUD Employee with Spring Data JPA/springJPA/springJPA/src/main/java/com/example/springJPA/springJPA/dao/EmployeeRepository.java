package com.example.springJPA.springJPA.dao;

import com.example.springJPA.springJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
