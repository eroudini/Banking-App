package com.eroudini.banking.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends AbstractEntity{


    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name ="id_user")
    private User user;
}
