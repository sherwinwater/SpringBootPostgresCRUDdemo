package com.sherwin.postgresdemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employeesrestdata")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/search/{ajxsearchcontent}")
	public List<Employee> search(@PathVariable("ajxsearchcontent") String ajxsearchcontent){
		System.out.println(ajxsearchcontent);
		return  employeeService.search(ajxsearchcontent);
	}

}
