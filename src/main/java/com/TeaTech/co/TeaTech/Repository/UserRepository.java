package com.TeaTech.co.TeaTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
