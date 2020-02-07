package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "persons") //This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//TODO: remove commented lines that no need for it
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;

    @Basic(optional = false)
    @NotBlank(message = "First name must not be blank")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters long")
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @NotBlank(message = "Last name must not be blank")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters long")
    @Column (name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @NotBlank(message = "Email must not be blank")
    @Column
//    @Email(message = "email must be in proper format") //seems too surface check
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message="not proper email format")
    private String email;

    @Column
    private String address;

    @Basic(optional = false)
    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 50)
    @Column
    private String username;

//    @RestResource(exported = false)
//    @JsonIgnore
    @Basic(optional = false)
    @NotBlank(message = "Password must not be blank")
    @Size(min = 3, max = 256)
    @Column
    private String password;

//    @OneToMany(mappedBy = "person")
//    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "persons_roles",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

}
