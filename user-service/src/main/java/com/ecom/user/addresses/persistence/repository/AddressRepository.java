package com.ecom.user.addresses.persistence.repository;

import com.ecom.user.addresses.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findByUserId(UUID userId);

    @Modifying
    @Query("delete from Address a where a.id = :id")
    int deleteIfExistsById(@Param("id") UUID id);
}
