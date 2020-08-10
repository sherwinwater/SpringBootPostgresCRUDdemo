package com.sherwin.postgresdemo.cart;

import com.sherwin.postgresdemo.book.Book;
import com.sherwin.postgresdemo.book.BookService;
import com.sherwin.postgresdemo.employee.Employee;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService{

    private final CartRepository cartRepository;
    private final BookService bookService;

    public CartService(CartRepository cartRepository, BookService bookService) {
        this.cartRepository = cartRepository;
        this.bookService = bookService;
    }

    public void save(Cart Cart) {
        cartRepository.save(Cart);
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart get(Employee employee) {
        return cartRepository.findCartByEmployee(employee);
    }

    public Cart getByid(Long id ) {
        return cartRepository.findCartById(id);
    }

    public void delete(Long id, Employee employee) {
        Cart cart = cartRepository.findCartByEmployee(employee);
        Book book = bookService.get(id);
        cart.removeBook(book);
        cartRepository.save(cart);
    }

}
