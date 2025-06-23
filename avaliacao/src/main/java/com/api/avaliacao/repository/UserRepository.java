// src/main/java/com/example/authserver/repository/UserRepository.java
package com.api.avaliacao.repository;

import com.api.avaliacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}