package com.sherwin.postgresdemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String home(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "employee/list";
    }

    @GetMapping("/employee/{id}")
    public String viewEmployee(@PathVariable Long id,Model model){
        Employee employee = employeeService.get(id);
        model.addAttribute("employee",employee);
        return "employee/view";
    }

}
