package com.TeaTech.co.TeaTech.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.TeaTech.co.TeaTech.NotFoundException.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String usernotFoundHandler(UserNotFoundException e){
        return e.getMessage();
    }
}
