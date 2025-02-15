package com.ayush.learning.Content.Calander.controller;

import com.ayush.learning.Content.Calander.entity.Comment;
import com.ayush.learning.Content.Calander.payload.CommentDto;
import com.ayush.learning.Content.Calander.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") Long postId,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value ="postId") Long postId) {
        return  commentService.getCommentByPostId(postId);
    }
    @GetMapping("/posts/{postId}/comments/{id}")
    public  ResponseEntity<CommentDto> getCommentById( @PathVariable(value ="postId") Long postId,
                                                       @PathVariable(value ="id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return  new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
