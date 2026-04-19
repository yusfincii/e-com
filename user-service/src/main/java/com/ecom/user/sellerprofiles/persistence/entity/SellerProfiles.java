package com.ecom.user.sellerprofiles.persistence.entity;

import com.ecom.user.common.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "SELLER_PROFILES", schema = "user_schema")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerProfiles extends BaseEntity {

    @JoinColumn(name = "user_id")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tax_number")
    private String taxNumber;
}
