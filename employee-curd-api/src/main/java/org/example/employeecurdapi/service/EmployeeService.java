package org.example.employeecurdapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.employeecurdapi.controller.EmployeeController;
import org.example.employeecurdapi.dao.EmployeeDao;
import org.example.employeecurdapi.entity.Employee;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee createEmployee(EmployeeController.EmployeeRequest employeeRequest) {
        Employee employee = toEmployee(employeeRequest);
        return employeeDao.save(employee);
    }

    private static Employee toEmployee(EmployeeController.EmployeeRequest employeeRequest) {
        return new Employee(
                employeeRequest.firstName(),
                employeeRequest.lastName(),
                employeeRequest.email(),
                employeeRequest.phoneNumber(),
                employeeRequest.hiredDate(),
                employeeRequest.salary()
        );
    }

    public Employee getEmployeeById(Integer id) {
        return employeeDao.findById(id).orElse(null);
    }

    public Employee updateEmployee(int id, EmployeeController.EmployeeRequest employeeRequest) {
        Employee employee = toEmployee(EmployeeController.EmployeeRequest);
        if (employeeDao.existsById(id)) {
            employee.setId(id);
            return employeeDao.save(employee);
        }
        throw new EntityNotFoundException("Employee with id " + id + " not found");

    }
}
