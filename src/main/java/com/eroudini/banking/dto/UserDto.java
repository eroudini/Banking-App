package com.eroudini.banking.dto;

import com.eroudini.banking.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    @NotNull(message = "Veuillez entrez votre prenom")
    @NotEmpty(message = "Veuillez entrez votre prenom")
    @NotBlank(message = "Veuillez entrez votre prenom")
    private String firstname;

    @NotNull(message = "Veuillez entrez votre nom")
    @NotEmpty(message = "Veuillez entrez votre nom")
    @NotBlank(message = "Veuillez entrez votre nom")
    private String lastname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    public UserDto() {}

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
