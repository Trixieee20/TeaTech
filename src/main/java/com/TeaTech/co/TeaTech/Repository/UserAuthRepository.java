package com.TeaTech.co.TeaTech.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long>{
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByUserName(String username);
    Optional<UserAuth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean eexistsByUsername(String username);
}

