package com.ayush.learning.Content.Calander.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

public  record Content(
                       @Id
                       Integer id,
                       @NotEmpty()
                       String title, String description,
                       Status status,
                       Type contentType,
                       LocalDateTime dateCreated,
                       LocalDateTime dateUpdated,
                       String ulr) {

}