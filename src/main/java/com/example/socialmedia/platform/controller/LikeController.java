package com.example.socialmedia.platform.controller;

import com.example.socialmedia.platform.entity.Comment;
import com.example.socialmedia.platform.entity.Like;
import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.service.CommentService;
import com.example.socialmedia.platform.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;


    //------------------------------------------------------------------
    @PostMapping("/setLike")
    public Like setLike(@RequestBody Like like){
        System.out.println(like);
        return likeService.setLike(like);
    }

    //------------------------------------------------------------------
    @GetMapping("/getLike/{id}")
    public Like getLike(@PathVariable int id){
        return likeService.getLike(id);
    }

    //-----------------------------------------------------------------
    @DeleteMapping("/unLike/{id}")
    public String unLike(@PathVariable int id)
    {
        return likeService.unLike(id);
    }
}
