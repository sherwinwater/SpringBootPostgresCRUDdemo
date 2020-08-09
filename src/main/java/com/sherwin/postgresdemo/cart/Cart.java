package com.sherwin.postgresdemo.cart;

import com.sherwin.postgresdemo.book.Book;
import com.sherwin.postgresdemo.config.Auditable;
import com.sherwin.postgresdemo.employee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Cart extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @OneToOne
    private Employee employee;

    @OneToMany(mappedBy = "cart")
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        this.bookList.add(book);
    }
}
