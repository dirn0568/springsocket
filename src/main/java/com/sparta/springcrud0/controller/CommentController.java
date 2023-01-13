package com.sparta.springcrud0.controller;

import com.sparta.springcrud0.dto.CommentRequestDto;
import com.sparta.springcrud0.dto.CommentResponseDto;
import com.sparta.springcrud0.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/api/comment/{id}")
    public CommentResponseDto commentCreate(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        CommentResponseDto commentResponseDto = commentService.createComment(id, commentRequestDto, request);
        return commentResponseDto;
    }

    @PutMapping("api/comment/{id}")
    public CommentResponseDto commentUpdate(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        CommentResponseDto commentResponseDto = commentService.updateComment(id, commentRequestDto, request);
        return commentResponseDto;
    }

    @DeleteMapping("api/comment/{id}")
    public Map commentDelete(@PathVariable Long id, HttpServletRequest request) {
        return commentService.deleteComment(id, request);
    }
}
