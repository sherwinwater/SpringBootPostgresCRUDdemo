package com.sherwin.postgresdemo.cart;

import com.sherwin.postgresdemo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartByEmployee(Employee employee);
    Cart findCartById(Long id);
}
