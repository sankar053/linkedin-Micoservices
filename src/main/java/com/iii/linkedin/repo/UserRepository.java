package com.iii.linkedin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.linkedin.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
