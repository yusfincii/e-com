package com.ecom.user.users.api.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDTO {

    private String userType;

    @NotBlank(message = "Email can not be blank!")
    @Email(message = "Please enter a valid email address!")
    @Size(max = 255, message = "Email can not be larger than 255 characters!")
    private String email;

    // ignore whitespace characters on leading and following
    @JsonSetter
    public void setEmail(String email) {
        this.email = email != null ? email.trim() : null;
    }

    @NotBlank(message = "Password can not be blank!")
    @Size(min = 8, max = 72, message = "Password length must be between 8-72 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
            message = "Password must contain at least one uppercase letter, one lowercase letter and one number!")
    private String password;

    // name and surname fields should be not blank
    // because they used on each user type
    @NotBlank(message = "Name can not be blank!")
    @Size(min = 3, max = 64)
    @Pattern(regexp = "^[\\p{L}]+(?:[ '-][\\p{L}]+)*$",
            message = "Name can only contain letters, spaces, hyphens, or apostrophes")
    private String name;

    @NotBlank(message = "Surname can not be blank!")
    @Size(min = 2, max = 64)
    @Pattern(regexp = "^[\\p{L}]+(?:[ '-][\\p{L}]+)*$",
            message = "Surname can only contain letters, spaces, hyphens, or apostrophes")
    private String surname;

    @Size(min = 7, max = 16)
    @Pattern(regexp = "^\\d{7,16}$",
            message = "Tax number must contain 7 to 16 digits")
    private String taxNumber;

    @Digits(integer = 3, fraction = 0,
            message = "Weight must be a whole number!")
    private Integer weight; // optional

    @Digits(integer = 3, fraction = 0,
            message = "Height must be a whole number!")
    private Integer height; // optional

    @NotNull(message = "Birth date field can not be null!")
    @PastOrPresent(message = "Birth date cannot be later than today!")
    private LocalDate birthDate;

    @NotBlank(message = "Phone number must be filled!")
    @Pattern(
            regexp = "^\\+[1-9]\\d{6,14}$",
            message = "Phone number must be in E.164 format (e.g. +905321234567)"
    )
    @Size(min = 7, max = 20, message = "Phone number must be between 6 and 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Gender field can not be blank!")
    private String gender;
}
