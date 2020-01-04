package com.sda.restaurant.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity(name = "persons") //This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor

@Data
@AllArgsConstructor

@ToString
//@Table(name = "persons")
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

//    public Person(){
//    }
//
//    public Person(String first_name, String last_name, String email, String address, String username, String password) {
//        this.firstName = first_name;
//        this.lastName = last_name;
//        this.email = email;
//        this.address = address;
//        this.username = username;
//        this.password = password;
//    }
}
