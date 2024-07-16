package com.ayush.learning.Content.Calander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    private String resourceName;
    private String fileName;
    private String fieldValue;

    public  ResourceNotFoundException(String resourceName, String fieldValue, String fileName) {
        super(String.format("%s not found with %s: %s", resourceName, fileName, fieldValue));
        this.resourceName = resourceName;
        this.fileName = fileName;
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getFileName() {
        return fileName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
