package com.ayush.learning.Content.Calander.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends  RuntimeException {

    private HttpStatus status;
    private String message;

    public BlogAPIException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public BlogAPIException(String message, String message1, HttpStatus status) {
        super(message);
        this.message = message1;
        this.status = status;
    }


    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
