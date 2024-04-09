package com.example.socialmedia.platform.service;

import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.entity.User;
import com.example.socialmedia.platform.repositary.PostRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepositary postRepository;

    //------------------------------------------------------------------
    public Post addPost(Post post){
        return postRepository.save(post) ;
    }

    //------------------------------------------------------------------

    public Post getPost(int id){
        Post post = postRepository.findById(id).orElse(null);
        if(post != null){
            return post;
        }else {
            return null;
        }
    }

    //------------------------------------------------------------------

    public String updatePost(int id,Post post){

        Post existingRecord = postRepository.findById(id).orElse(null);

        if(existingRecord != null){

            existingRecord.setContent(post.getContent());
            existingRecord.setUser_id(post.getUser_id());

            postRepository.save(existingRecord);
            return "Post updated..! ";
        }else{
            return "Not found..!";
        }
    }

    //-------------------------------------------------------------------

    public String deletePost(int id) {
        Optional<Post> op_post = postRepository.findById(id);

        if (op_post.isPresent()) {
            postRepository.deleteById(id);
            return "Post deleted..!";
        } else {
            return "Post not found.!";
        }
    }
}
