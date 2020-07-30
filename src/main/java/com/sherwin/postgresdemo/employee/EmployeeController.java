package com.sherwin.postgresdemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String home(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "employees";
    }
}
