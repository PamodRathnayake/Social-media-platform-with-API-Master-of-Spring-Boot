package com.example.socialmedia.platform.controller;

import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.entity.User;
import com.example.socialmedia.platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    //------------------------------------------------------------------
    @PostMapping("/createPost")
    public Post createPost(@RequestBody Post post){
        System.out.println(post);
        return postService.addPost(post);
    }

    //------------------------------------------------------------------
    @GetMapping("/getPost/{id}")
    public Post getPost(@PathVariable int id){
        return postService.getPost(id);
    }

    //------------------------------------------------------------------
    @PutMapping("/updatePost/{id}")
    public String updatePost( @PathVariable int id, @RequestBody Post post)
    {
        System.out.println(id+"  "+ post);
        return postService.updatePost(id, post);
    }

    //-----------------------------------------------------------------
    @DeleteMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id)
    {
        return postService.deletePost(id);
    }

}
