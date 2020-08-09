package com.sherwin.postgresdemo.cart;

import com.sherwin.postgresdemo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
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

    public void delete(Long id) {
        cartRepository.deleteById(id);
    }


}
