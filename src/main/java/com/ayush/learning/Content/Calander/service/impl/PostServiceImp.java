package com.ayush.learning.Content.Calander.service.impl;
import com.ayush.learning.Content.Calander.entity.Post;
import com.ayush.learning.Content.Calander.payload.PostDto;
import com.ayush.learning.Content.Calander.repository.PostRepository;
import com.ayush.learning.Content.Calander.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());

          Post post = mapToPost(postDto);

        // save to the database
        Post newPost = postRepository.save(post);

        return mapToDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
       return  posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    private PostDto mapToDto(Post newPost) {
        PostDto postResponse = new PostDto();
        postResponse.setId((newPost.getId()));
        postResponse.setTitle(newPost.getTitle());
        postResponse.setContent(newPost.getContent());
        postResponse.setDescription(newPost.getDescription());
        return postResponse;
    }

    private Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
