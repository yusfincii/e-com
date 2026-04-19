package com.ecom.user.users.api.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersUpdateRequestDTO {

    private String userType;


    @Email(message = "Please enter a valid email address!")
    @Size(max = 255, message = "Email can not be larger than 255 characters!")
    private String email;

    // ignore whitespace characters on leading and following
    @JsonSetter
    public void setEmail(String email) {
        this.email = email != null ? email.trim() : null;
    }

    @Size(min = 8, max = 72, message = "Password length must be between 8-72 characters!")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
            message = "Password must contain at least one uppercase letter, one lowercase letter and one number!")
    private String password;
}
