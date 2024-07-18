package com.ayush.learning.Content.Calander.service.impl;

import com.ayush.learning.Content.Calander.entity.Comment;
import com.ayush.learning.Content.Calander.entity.Post;
import com.ayush.learning.Content.Calander.exception.BlogAPIException;
import com.ayush.learning.Content.Calander.exception.ResourceNotFoundException;
import com.ayush.learning.Content.Calander.payload.CommentDto;
import com.ayush.learning.Content.Calander.repository.CommentRepository;
import com.ayush.learning.Content.Calander.repository.PostRepository;
import com.ayush.learning.Content.Calander.service.CommentService;
import com.ayush.learning.Content.Calander.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);
        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map( comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Postid", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
        if( ! comment.getPost().getId().equals(post.getId())) {
            throw  new BlogAPIException("Comment does not belong to post", HttpStatus.BAD_REQUEST);//
        }
        return  mapToDTO(comment);
    }

    private CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setBody(comment.getName());
        commentDto.setEmail(comment.getEmail());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        return comment;
    }
}
