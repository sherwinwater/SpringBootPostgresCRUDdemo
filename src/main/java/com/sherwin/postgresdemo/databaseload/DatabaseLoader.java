package com.sherwin.postgresdemo.databaseload;

import com.sherwin.postgresdemo.model.Employee;
import com.sherwin.postgresdemo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private EmployeeService employeeService;

    public DatabaseLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee one = new Employee("sam","s","sam@sam.com");
        employeeService.save(one);
    }
}
