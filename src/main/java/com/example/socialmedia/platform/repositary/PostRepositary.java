package com.example.socialmedia.platform.repositary;

import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*@Repository
public interface PostRepositary extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
}*/
@Repository
public interface PostRepositary extends JpaRepository<Post,Integer> {

    @Query(value = "SELECT * FROM posts where user_id = :user_id ORDER BY id DESC", nativeQuery = true)
    List<Post> getPost(int user_id);

}


