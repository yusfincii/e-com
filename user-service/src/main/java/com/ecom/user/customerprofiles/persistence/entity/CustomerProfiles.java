package com.ecom.user.customerprofiles.persistence.entity;

import com.ecom.user.common.persistence.BaseEntity;
import com.ecom.user.customerprofiles.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER_PROFILES", schema = "user_schema")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerProfiles extends BaseEntity {

    @JoinColumn(name = "user_id")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
