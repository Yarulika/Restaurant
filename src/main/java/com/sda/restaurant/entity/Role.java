package com.sda.restaurant.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    @Column(name = "role_title")
    private String roleTitle;

//    @ManyToMany(mappedBy = "roles")
//    private Set<Person> persons = new HashSet<>(); //NO NEED IN IT

}
