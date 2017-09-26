package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_address")
public class Address {
    @Id
    private String id;
    private String address;
}
