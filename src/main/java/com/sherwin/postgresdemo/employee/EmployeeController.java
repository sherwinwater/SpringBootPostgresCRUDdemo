package com.sherwin.postgresdemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/search")
    public String search(@RequestParam("searchcontent") String searchcontent, Model model){
        List<Employee> search = employeeService.search(searchcontent);
        model.addAttribute("employees",search);
        return "employee/list";
    }

    @GetMapping("/ajaxsearch2")
    @ResponseBody
    public String showEmployee(Model model){
        return "3";
    }

    @GetMapping("/ajaxsearch3/{searchcontent}")
    public String showEmployee2(@PathVariable String searchcontent, Model model){
        List<Employee> search = employeeService.search(searchcontent);
        model.addAttribute("employees",search);
        return "employee/list :: table-refresh";
    }

}
