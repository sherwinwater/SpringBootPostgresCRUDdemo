package com.sherwin.postgresdemo.employee;

import com.sherwin.postgresdemo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(Long id);
    List<Employee> findByFirstNameOrLastNameOrEmailIdContaining(String firstname,String lastname,String email);
}
