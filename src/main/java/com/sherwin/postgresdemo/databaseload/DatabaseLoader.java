package com.sherwin.postgresdemo.databaseload;

import com.sherwin.postgresdemo.employee.Employee;
import com.sherwin.postgresdemo.employee.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private EmployeeService employeeService;

    public DatabaseLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee one = new Employee("sam","s","sam@sam.com");
        one.setDate(LocalDateTime.now());
        employeeService.save(one);
    }
}
