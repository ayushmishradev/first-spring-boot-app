package com.ayush.learning.Content.Calander.service;

import com.ayush.learning.Content.Calander.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
}
