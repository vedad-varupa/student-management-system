package com.example.Student.exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(final String message) {
        super(message);
    }
}

