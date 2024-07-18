package com.ayush.learning.Content.Calander.service;

import com.ayush.learning.Content.Calander.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(Long postId);

    CommentDto getCommentById( Long postId, Long commentId);
}
