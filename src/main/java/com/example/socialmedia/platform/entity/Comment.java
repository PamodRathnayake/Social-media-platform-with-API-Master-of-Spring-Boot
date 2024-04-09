package com.example.socialmedia.platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    private String content;
    private int user_id;
    private int post_id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime addDateTime;
    @PrePersist
    public void prePersist() {
        addDateTime = LocalDateTime.now();
    }
}
