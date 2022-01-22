package com.example.thepolitcookbook.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class AlreadyExistsError extends Error {

    public AlreadyExistsError(String message) {
        super(message);
    }
}
