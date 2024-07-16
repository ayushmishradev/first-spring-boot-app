package com.ayush.learning.Content.Calander.controller;


import com.ayush.learning.Content.Calander.payload.PostDto;
import com.ayush.learning.Content.Calander.service.PostService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService  = postService;
    }

    // create blog rest point

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return  new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        return  postService.getAllPosts();
    }
}
