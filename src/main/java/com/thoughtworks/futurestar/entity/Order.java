package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order")
@Entity
public class Order {
    @Id
    private String id;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "t_order_item",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> itemList = new ArrayList<>();
}
