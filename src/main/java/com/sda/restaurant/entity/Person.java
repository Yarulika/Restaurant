package com.sda.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "persons")
public class Person {
    @Column(name = "person_id")
    @Id
    private int personId;
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

    public Person(String first_name, String last_name, String email, String address, String username, String password) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }
}
