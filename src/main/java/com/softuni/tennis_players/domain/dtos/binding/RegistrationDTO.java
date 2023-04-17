package com.softuni.tennis_players.domain.dtos.binding;

import com.softuni.tennis_players.validations.matchingPasswords.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class RegistrationDTO {
    // toDO fullNAME !!!
    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;

    @NotNull
    @Size(min = 4, max = 20)
    private String username;

    public RegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public RegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return username;
    }

    public RegistrationDTO setUserName(String userName) {
        this.username = userName;
        return this;
    }

    public RegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
