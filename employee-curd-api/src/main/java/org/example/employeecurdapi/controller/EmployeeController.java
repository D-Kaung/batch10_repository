package org.example.employeecurdapi.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.example.employeecurdapi.entity.Employee;
import org.example.employeecurdapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {

    public static EmployeeController.EmployeeRequest EmployeeRequest;
    private final EmployeeService employeeService;

   public record EmployeeResponse(int id,
                            @JsonProperty("first_name")String firstName,
                            @JsonProperty("last_name")String lastName,
                            String email,
                            String phoneNumber,
                            @JsonProperty("hired_date")LocalDate hiredDate,
                            double salary
                       ){}

    //firstName,lastName,email,phoneNumber,hiredDate,salary
   public record EmployeeRequest(String firstName,
                           String lastName,
                           String email,
                           String phoneNumber,
                           LocalDate hiredDate,
                           double salary){

    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.createEmployee(employeeRequest);
        return toEmployeeResponse(employee);
    }

    @GetMapping
    public List<EmployeeResponse> listAllEmployees() {
        return employeeService.findAllEmployees()
                .stream()
                .map(e -> toEmployeeResponse(e))
                .collect(Collectors.toUnmodifiableList());
    }

    private static EmployeeResponse toEmployeeResponse(Employee e) {
        return new EmployeeResponse(e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getPhoneNumber(),
                e.getHireDate(),
                e.getSalary());
    }

    @GetMapping("/{id}")
    public EmployeeResponse findEmployeeById(@PathVariable("id") int id) {
       Employee employee = employeeService.getEmployeeById(id);
       return toEmployeeResponse(employee);
    }
    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest,
                                           @PathVariable("id") int id){
       Employee employee = employeeService.updateEmployee(id, employeeRequest);
       return toEmployeeResponse(employee);
    }

}
