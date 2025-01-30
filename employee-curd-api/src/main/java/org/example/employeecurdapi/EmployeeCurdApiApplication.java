package org.example.employeecurdapi;

import lombok.RequiredArgsConstructor;
import org.example.employeecurdapi.dao.EmployeeDao;
import org.example.employeecurdapi.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeCurdApiApplication {


    private final EmployeeDao employeeDao;

   @Bean
   @Profile("dev")
    public ApplicationRunner runner() {
        return args -> {
            List.of(
                    new Employee("jj","j","j@gmail.com","77-777-77", LocalDate.of(2023,3,2),600),
            new Employee("gg","g","g@gmail.com","77-677-77", LocalDate.of(2023,5,4),60)
            ).forEach(employeeDao::save);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(EmployeeCurdApiApplication.class, args);
    }

}
