package com.ecom.user.users.api.dto;

import com.ecom.user.customerprofiles.enumeration.Gender;
import com.ecom.user.users.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDTO {

    private UUID userId;
    private UserType userType;
    private String email;
    private String name;
    private String surname;
    private String taxNumber;
    private Integer weight;
    private Integer height;
    private LocalDate birthDate;
    private String phoneNumber;
    private Gender gender;

}
