package com.nicolasf.restwebservices.restfulwebservices.jpa;

import com.nicolasf.restwebservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
