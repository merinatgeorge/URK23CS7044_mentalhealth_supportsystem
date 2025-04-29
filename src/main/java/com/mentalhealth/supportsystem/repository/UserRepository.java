package com.mentalhealth.supportsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentalhealth.supportsystem.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // ✅ For Spring Security

    // You can keep this for manual login if needed
    User findByEmailAndPassword(String email, String password);
}
