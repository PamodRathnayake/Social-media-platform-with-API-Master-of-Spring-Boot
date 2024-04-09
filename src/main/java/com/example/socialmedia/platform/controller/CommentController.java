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
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;


    //------------------------------------------------------------------
    @PostMapping("/createComment")
    public Comment createComment(@RequestBody Comment comment){
        System.out.println(comment);
        return commentService.createComment(comment);
    }

    //------------------------------------------------------------------
    @GetMapping("/getComment/{id}")
    public Comment getComment(@PathVariable int id){
        return commentService.getComment(id);
    }

    //------------------------------------------------------------------
    @PutMapping("/updateComment/{id}")
    public String updateComment( @PathVariable int id, @RequestBody Comment comment)
    {
        System.out.println(id+"  "+ comment);
        return commentService.updateComment(id, comment);
    }

    //-----------------------------------------------------------------
    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable int id)
    {
        return commentService.deleteComment(id);
    }

}

