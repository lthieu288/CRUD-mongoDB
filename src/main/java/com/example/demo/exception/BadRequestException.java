package com.example.demo.exception;


import com.mongodb.lang.Nullable;

public class BadRequestException extends IllegalArgumentException {

    public BadRequestException(@Nullable String message) {
        super(message);
    }
}
