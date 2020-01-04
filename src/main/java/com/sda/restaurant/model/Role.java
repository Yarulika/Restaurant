package com.sda.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "roles")
public class Role {
    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @Column(name = "role_title")
    private String roleTitle;

    public Role(String roleTitle){
        this.roleTitle = roleTitle;
    }
}
