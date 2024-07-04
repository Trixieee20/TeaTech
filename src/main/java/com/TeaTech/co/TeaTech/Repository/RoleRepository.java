package com.TeaTech.co.TeaTech.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);

}
