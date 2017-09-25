package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_shopping_carts")
public class ShoppingCart {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "t_shopping_cart_item",
            joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> itemList = new ArrayList<>();
}