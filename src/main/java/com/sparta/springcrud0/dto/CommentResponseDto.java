package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private long id;
    private String content;
    private String name;

    public CommentResponseDto(Comment comment) {
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.id = comment.getId();
        this.content = comment.getContent();
        this.name = comment.getMember().getName();
    }
}
