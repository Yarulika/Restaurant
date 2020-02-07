package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO: great idea do it & remove unused lines
//could be ENUM

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role_title")
//    @Enumerated(EnumType.STRING)
    private String roleTitle;
//    private RoleTitle roleTitle;

//    @ManyToMany(mappedBy = "roles")
//    private Set<Person> persons = new HashSet<>();


//    public enum RoleTitle {
//        CUSTOMER,
//        EMPLOYEE;
//    }
}
