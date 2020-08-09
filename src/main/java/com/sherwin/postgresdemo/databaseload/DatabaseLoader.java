package com.sherwin.postgresdemo.databaseload;

import com.sherwin.postgresdemo.book.Book;
import com.sherwin.postgresdemo.book.BookService;
import com.sherwin.postgresdemo.cart.Cart;
import com.sherwin.postgresdemo.cart.CartService;
import com.sherwin.postgresdemo.employee.Employee;
import com.sherwin.postgresdemo.employee.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private EmployeeService employeeService;
    private BookService bookService;
    private CartService cartService;

    public DatabaseLoader(EmployeeService employeeService, BookService bookService, CartService cartService) {
        this.employeeService = employeeService;
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee one = new Employee("sam","s","sam@sam.com","images/Apocalypto.png");
        Employee two = new Employee("jack","jack","jakc@sam.com","images/concussion.png");
        Employee three = new Employee("tom","tomes","tom@sam.com","images/legendsofthefall.png");
        Employee four = new Employee("andy","s","andy@sam.com","images/thehuntingground.png");
        Employee five = new Employee("joe","s","joe@sam.com","images/larry.png");
        Employee six = new Employee("thomas","s","tomas@sam.com","images/timemachine.png");
//        one.setDate(LocalDateTime.now());
        employeeService.save(one);
        employeeService.save(two);
        employeeService.save(three);
        employeeService.save(four);
        employeeService.save(five);
        employeeService.save(six);

        Book book1 = new Book("Apocalypto",45.49,"images/Apocalypto.png");
        Book book2 = new Book("concussion",45.49,"images/concussion.png");
        Book book3 = new Book("legends of the fall",45.49,"images/legendsofthefall.png");
        Book book4 = new Book("the hunting ground",45.49,"images/thehuntingground.png");
        Book book5 = new Book("larry friends",45.49,"images/larry.png");
        Book book6 = new Book("time machine",45.49,"images/timemachine.png");

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
        bookService.save(book6);

        Employee employee = employeeService.get(1L);
        Cart cart = new Cart();
        cart.setEmployee(employee);
        cart.addBook(book1);
        cartService.save(cart);

    }
}
