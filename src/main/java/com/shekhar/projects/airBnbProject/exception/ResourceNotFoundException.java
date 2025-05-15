package com.shekhar.projects.airBnbProject.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String message){
        super(message);
    }
    
}
