package com.ayush.learning.Content.Calander.controller;

import com.ayush.learning.Content.Calander.model.Content;
import com.ayush.learning.Content.Calander.repositry.ContentCreatorRepositry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentCreatorRepositry repositry;

    @Autowired
    public ContentController(ContentCreatorRepositry repositry) {
        this.repositry = repositry;
    }

    //make a request and findAll the pieces of content in the system
    @GetMapping()
    public List<Content> findAll(){
        System.out.println("in Find All");
        return this.repositry.findAll();
    }

    // Create Read Update Delete - Filter, Pagination and Sorting

    @GetMapping("/{id}")
    public Optional<Content> findContentById(@PathVariable Integer id) {
            return  repositry.findById(id);
    }

    public void create( @Valid @RequestBody Content content) {
        repositry.saveContent(content);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Content content, Integer id) {
        if( ! repositry.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content could not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContent(Integer id) {
        repositry.deleteContent(id);
    }
}
