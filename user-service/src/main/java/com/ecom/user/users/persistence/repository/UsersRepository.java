package com.ecom.user.users.persistence.repository;

import com.ecom.user.users.persistence.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    boolean existsById(UUID id);

    boolean existsByEmail(String email);
}
