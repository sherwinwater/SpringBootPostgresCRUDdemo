package com.sherwin.postgresdemo.cart;

import com.sherwin.postgresdemo.book.BookService;
import com.sherwin.postgresdemo.employee.Employee;
import com.sherwin.postgresdemo.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BookService bookService;

    @GetMapping("/cart")
    public String getList(Model model){
        Employee employee = employeeService.get(1L);
        Cart cart = cartService.get(employee);
        model.addAttribute("cart", cart);
        return "cart/list";
    }

    @GetMapping("/cart/add/{id}")
    public String addBook(@PathVariable long id){
        Employee employee = employeeService.get(1L);
        Cart cart = cartService.get(employee);
        cart.addBook(bookService.get(id));
        cartService.save(cart);
        return "redirect:/books";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteBook(@PathVariable long id){
        Employee employee = employeeService.get(1L);
        cartService.delete(id,employee);
        return "redirect:/cart";
    }

}
