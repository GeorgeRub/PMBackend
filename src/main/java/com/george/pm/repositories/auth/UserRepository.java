package com.george.pm.repositories.auth;

import java.util.Optional;

import com.george.pm.models.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.username = :username")
    User findByUsernameOne(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
