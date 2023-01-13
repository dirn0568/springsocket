package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.entity.Board;
import com.sparta.springcrud0.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardResponseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private long id;
    private String title;
    private String content;
    private String memberName;

    private List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

    public BoardResponseDto(Board board) {
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.memberName = board.getMember().getName();
        for (Comment comment : board.getComment()) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            this.commentResponseDtoList.add(commentResponseDto);
        }
    }
}
