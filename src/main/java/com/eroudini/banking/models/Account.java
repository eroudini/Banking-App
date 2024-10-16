package com.eroudini.banking.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account extends AbstractEntity{


    private String iban;


    @OneToOne
    @JoinColumn(name ="id_user")
    private User user;
}
