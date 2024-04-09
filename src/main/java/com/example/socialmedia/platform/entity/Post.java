package com.example.socialmedia.platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private int id;
    private String content;
    private String location;
    private int user_id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime addDateTime;
    @PrePersist
    public void prePersist() {
        addDateTime = LocalDateTime.now();
    }


}
