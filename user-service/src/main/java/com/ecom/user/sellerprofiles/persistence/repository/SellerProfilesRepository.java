package com.ecom.user.sellerprofiles.persistence.repository;

import com.ecom.user.sellerprofiles.persistence.entity.SellerProfiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerProfilesRepository extends JpaRepository<SellerProfiles, UUID> {
}
