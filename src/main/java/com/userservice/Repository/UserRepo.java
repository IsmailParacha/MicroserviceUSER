package com.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
