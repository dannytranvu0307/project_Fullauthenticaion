package com.example.project_FullAuthentication.Repository;

import com.example.project_FullAuthentication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface userRepository extends JpaRepository <User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByVerifyCode(String verifyCode);
    @Modifying
    void deleteById(Long id);
    @Query("select count(u) from User u where u.email = ?1 and (u.status = 1 or u.status = 2)")
    Long findActiveUserByEmail(String email);
    Boolean existsByEmail(String email);
    @Modifying
    User save(User user);
}
