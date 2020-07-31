package com.sherwin.postgresdemo.employee;

import com.sherwin.postgresdemo.employee.Employee;
import com.sherwin.postgresdemo.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Employee get(Long id){return employeeRepository.findEmployeeById(id);}
    public void delete(Long id){employeeRepository.deleteById(id);}

    public List<Employee> search(String content) {
        return employeeRepository.findByFirstNameOrLastNameOrEmailIdContaining(content,content,content);
    }

}
