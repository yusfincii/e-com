package com.ecom.user.favourites.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "product_id")
    private UUID productId;

    // for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavouritesId other)) return false;
        return Objects.equals(userId, other.userId) &&
                Objects.equals(productId, other.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }
}
