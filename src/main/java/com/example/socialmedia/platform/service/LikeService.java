package com.example.socialmedia.platform.service;

import com.example.socialmedia.platform.entity.Comment;
import com.example.socialmedia.platform.entity.Like;
import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.repositary.LikeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepositary likeRepository;

    //------------------------------------------------------------------
    public Like setLike(Like like) {
        return likeRepository.save(like);
    }

    //------------------------------------------------------------------

    public Like getLike(int id){
        Like like = likeRepository.findById(id).orElse(null);
        if(like != null){
            return like;
        }else {
            return null;
        }
    }

    //------------------------------------------------------------------

    public String unLike(int id) {
        Optional<Like> op_like = likeRepository.findById(id);

        if (op_like.isPresent()) {
            likeRepository.deleteById(id);
            return "Unlike Successful..!";
        } else {
            return "Unlike not found.!";
        }
    }
}
