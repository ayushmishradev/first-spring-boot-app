package com.ayush.learning.Content.Calander.repositry;

import com.ayush.learning.Content.Calander.model.Content;
import com.ayush.learning.Content.Calander.model.Status;
import com.ayush.learning.Content.Calander.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCreatorRepositry {

    private final List<Content> content = new ArrayList<>();

    public void contentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1, "My Firts Content", "Description", Status.IDEA, Type.ARTICLE,
        LocalDateTime.now(), LocalDateTime.now(), "ABC");

        content.add(c);
    }

    @PostMapping("")
    public void saveContent(@RequestBody Content c) {
        content.add(c);
    }

    public boolean existById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteContent(Integer id) {
        content.removeIf(c -> c.id().equals(id));
    }
}
