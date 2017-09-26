package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_user")
public class User {
    @Id
    private String id;

    @Column(unique = true)
    private String username;
    private String password;
    private Integer age;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Address> addresses;
}
