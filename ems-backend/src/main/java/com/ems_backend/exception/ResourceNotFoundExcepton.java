package com.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepton extends RuntimeException{

    public ResourceNotFoundExcepton(String message){
        super(message);
    }
}
