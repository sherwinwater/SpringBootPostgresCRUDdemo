package com.sherwin.postgresdemo.service;

import com.sherwin.postgresdemo.model.Employee;
import com.sherwin.postgresdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee){employeeRepository.save(employee);}
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
