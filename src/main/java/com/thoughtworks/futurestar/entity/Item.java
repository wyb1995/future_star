package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_item")
@Entity
public class Item {
    @Id
    private String id;

    private String name;
    private String price;
}
