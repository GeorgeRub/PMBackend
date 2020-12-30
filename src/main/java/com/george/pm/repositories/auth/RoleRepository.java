package com.george.pm.repositories.auth;

import java.util.Optional;

import com.george.pm.models.auth.ERole;
import com.george.pm.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
