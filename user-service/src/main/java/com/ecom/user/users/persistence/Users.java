package com.ecom.user.users.persistence;

import com.ecom.user.common.persistence.BaseEntity;
import com.ecom.user.users.enumeration.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "users", schema = "user_schema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted=false")
public class Users extends BaseEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}
