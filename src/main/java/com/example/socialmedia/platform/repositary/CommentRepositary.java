package com.example.socialmedia.platform.repositary;

import com.example.socialmedia.platform.entity.Comment;
import com.example.socialmedia.platform.entity.Like;
import com.example.socialmedia.platform.entity.Post;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface CommentRepositary extends JpaRepository<Comment, Integer> {
    //List<Comment> findByPost(Post post);
}
