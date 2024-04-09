package com.example.socialmedia.platform.repositary;

import com.example.socialmedia.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
