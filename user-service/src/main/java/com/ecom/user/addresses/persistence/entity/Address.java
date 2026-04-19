package com.ecom.user.addresses.persistence.entity;

import com.ecom.user.addresses.enumeration.AddressStatus;
import com.ecom.user.common.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "addresses", schema = "user_schema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    @JoinColumn(name = "user_id")
    private UUID userId;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AddressStatus status;
}
