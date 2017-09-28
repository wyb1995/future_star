package com.thoughtworks.futurestar.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_role")
public class Role implements Serializable {

    public enum Symbol {
        SYSTEM_ADMIN("系统管理员"),
        PROJECT_MANAGER("项目经理"),
        CONSTRUCTOR("施工人员"),
        PROSPECTOR("工勘人员");

        private String description;

        Symbol(String description) {
            this.description = description;
        }

        public String description() {
            return description;
        }
    }

    @Id
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_privilege", joinColumns = @JoinColumn(name = "role_symbol", referencedColumnName = "symbol"),
            inverseJoinColumns = @JoinColumn(name = "privilege_symbol", referencedColumnName = "symbol"))
    private List<Privilege> privileges = new ArrayList<>();

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        name = symbol.description();
    }
}
