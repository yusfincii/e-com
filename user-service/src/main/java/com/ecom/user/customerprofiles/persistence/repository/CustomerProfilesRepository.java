package com.ecom.user.customerprofiles.persistence.repository;

import com.ecom.user.customerprofiles.persistence.entity.CustomerProfiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerProfilesRepository extends JpaRepository<CustomerProfiles, UUID> {
}
