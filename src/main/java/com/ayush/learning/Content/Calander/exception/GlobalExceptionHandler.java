package com.ayush.learning.Content.Calander.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity handleAccessDeniedException(AccessDeniedException exception , WebRequest webRequest) {
//        errorDetails
//    }
}
