package com.ecom.user.favourites.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "FAVOURITES", schema = "user_schema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted=false")
public class Favourites {

    @EmbeddedId
    private FavouritesId id;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
