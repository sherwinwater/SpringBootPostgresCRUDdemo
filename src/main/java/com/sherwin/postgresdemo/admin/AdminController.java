package com.sherwin.postgresdemo.admin;

import com.sherwin.postgresdemo.employee.Employee;
import com.sherwin.postgresdemo.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/admin/employee/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.get(id));
        return "employee/view";
    }

    @GetMapping("/admin/employee/edit/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.get(id);
        model.addAttribute("employee", employee);
        return "admin/employeeform";
    }

    @GetMapping("/admin/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/admin/employee/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/employeeform";
    }

    @PostMapping("/admin/employee/save")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeService.findAll());
            return "employee/list";
        } else {
            employeeService.save(employee);
            return "redirect:/admin/employee/"+employee.getId();
        }
    }

}
