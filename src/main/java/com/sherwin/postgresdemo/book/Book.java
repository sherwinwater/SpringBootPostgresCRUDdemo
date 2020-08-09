package com.sherwin.postgresdemo.book;

import com.sherwin.postgresdemo.cart.Cart;
import com.sherwin.postgresdemo.config.Auditable;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private double price;

    @NonNull
    private String photoUrl;

    private long quantity;

    @ManyToOne
    private Cart cart;
}
