package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "persons") //This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Column(name = "person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId; //UUID ?
    @Column(name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String username;
    @Column
    private String password;

    //Orders
    @OneToMany(mappedBy = "person")
    private List<Order> orders;

    //Roles
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "persons_roles",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

}
