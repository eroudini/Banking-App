package com.eroudini.banking.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends AbstractEntity{

    private Integer id;

    private String firstname;

    private  String lastname;

    private String email;

    private String password;

    private boolean active;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transaction;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToOne
    private Account account;

    @OneToOne
    private Role role;





}
