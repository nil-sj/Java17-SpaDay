package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {

    @NotBlank
    @Size(min=5, max=15, message="Username must be between 5 and 15 characters." )
    private String username;

    @Email(message="Invalid email. Try again.")
    private String email;
    @NotBlank
    @Size(min=6, message="The password should be at least 6 characters long.")
    private String password;

    @NotNull(message="Passwords do not match!")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    private void checkPassword() {
        if (!isNull(password) && !isNull(verifyPassword) && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

}
