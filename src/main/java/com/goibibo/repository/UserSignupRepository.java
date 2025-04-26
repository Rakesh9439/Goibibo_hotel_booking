package com.goibibo.repository;

import com.goibibo.entity.UserSignup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSignupRepository extends JpaRepository<UserSignup, Long> {

    Optional<UserSignup> findByUsername(String username);
}