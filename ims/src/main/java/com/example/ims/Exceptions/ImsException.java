package com.example.ims.Exceptions;

import org.springframework.http.HttpStatus;

public class ImsException extends RuntimeException {
    private  HttpStatus status;

    public ImsException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    public static ImsException notFound(String message) {
        return new ImsException(HttpStatus.NOT_FOUND, message);
    }
}
