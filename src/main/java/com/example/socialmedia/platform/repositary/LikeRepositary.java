package com.example.socialmedia.platform.repositary;

import com.example.socialmedia.platform.entity.Like;
import com.example.socialmedia.platform.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepositary extends JpaRepository<Like, Integer> {
    //List<Like> findByPost(Post post);
}

