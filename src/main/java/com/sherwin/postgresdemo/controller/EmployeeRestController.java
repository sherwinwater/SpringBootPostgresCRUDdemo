package com.sherwin.postgresdemo.controller;

import com.sherwin.postgresdemo.model.Employee;
import com.sherwin.postgresdemo.repository.EmployeeRepository;
import com.sherwin.postgresdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.findAll();
	}

}
