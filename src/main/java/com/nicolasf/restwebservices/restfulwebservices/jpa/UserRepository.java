package com.nicolasf.restwebservices.restfulwebservices.jpa;

import com.nicolasf.restwebservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
