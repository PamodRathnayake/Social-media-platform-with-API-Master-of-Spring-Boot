package com.example.socialmedia.platform.service;

import com.example.socialmedia.platform.entity.Comment;
import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.repositary.CommentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepositary commentRepository;



    /*public List<Comment> getPostComments(Post post) {
        return commentRepository.findByPost(post);
    }*/

    //------------------------------------------------------------------
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    //------------------------------------------------------------------

    public Comment getComment(int id){
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null){
            return comment;
        }else {
            return null;
        }
    }

    //------------------------------------------------------------------

    public String updateComment(int id,Comment comment){

        Comment existingRecord = commentRepository.findById(id).orElse(null);

        if(existingRecord != null){

            existingRecord.setContent(comment.getContent());
            existingRecord.setUser_id(comment.getUser_id());
            existingRecord.setPost_id(comment.getPost_id());

            commentRepository.save(existingRecord);
            return "Comment updated..! ";
        }else{
            return "Comment not found..!";
        }
    }

    //-------------------------------------------------------------------

    public String deleteComment(int id) {
        Optional<Comment> op_comment = commentRepository.findById(id);

        if (op_comment.isPresent()) {
            commentRepository.deleteById(id);
            return "Comment deleted..!";
        } else {
            return "Comment not found.!";
        }
    }
}

