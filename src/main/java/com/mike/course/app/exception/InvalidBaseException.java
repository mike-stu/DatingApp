package com.mike.course.app.exception;

import org.springframework.http.HttpStatus;

public abstract class InvalidBaseException extends Exception {

    private HttpStatus errorCode;
    private String errorMessage;

    public InvalidBaseException (HttpStatus errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
