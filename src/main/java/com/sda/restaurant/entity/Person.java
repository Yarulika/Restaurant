package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId; //UUID ?
    @Basic(optional = false)
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Column (name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column
    //Add RegExp
    private String email;
    @Column
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 50)
    @Column
    private String username;
//    @RestResource(exported = false)
//    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 256)
    @Column
    private String password;

    //Orders
//    @OneToMany(mappedBy = "person")
//    private List<Order> orders;

    //Roles
    @ManyToMany
    @JoinTable(
            name = "persons_roles",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

}
