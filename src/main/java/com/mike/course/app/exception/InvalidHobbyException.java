package com.mike.course.app.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class InvalidHobbyException extends Exception {
    private HttpStatus errorCode;
    private String errorMessage;

    public InvalidHobbyException(HttpStatus errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
