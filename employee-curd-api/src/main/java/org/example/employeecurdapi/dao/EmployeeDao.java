package org.example.employeecurdapi.dao;

import org.example.employeecurdapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
