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
        Employee one = new Employee("sam","s","sam@sam.com","images/Apocalypto.png");
        Employee two = new Employee("jack","jack","jakc@sam.com","images/concussion.png");
        Employee three = new Employee("tom","tomes","tom@sam.com","images/legendsofthefall.png");
        Employee four = new Employee("andy","s","andy@sam.com","images/thehuntingground.png");
        Employee five = new Employee("joe","s","joe@sam.com","images/larry.png");
        Employee six = new Employee("thomas","s","tomas@sam.com","images/timemachine.png");
//        one.setDate(LocalDateTime.now());
        employeeService.save(one);
        employeeService.save(two);
        employeeService.save(three);
        employeeService.save(four);
        employeeService.save(five);
        employeeService.save(six);
    }
}
