package com.example.demo.exception;

import com.mongodb.lang.Nullable;

public class NotFoundException extends IllegalArgumentException {
    private static final long serialVersionUID = -3946078288741435789L;

    public NotFoundException(@Nullable String message) {
        super(message);
    }
}
