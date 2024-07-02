package com.TeaTech.co.TeaTech.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.TeaTech.co.TeaTech.NotFoundException.OrderItemNotFoundException;
import com.TeaTech.co.TeaTech.NotFoundException.OrderNotFoundException;

@RestControllerAdvice
public class OrderItemExceptionHandler {

    @ExceptionHandler(OrderItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderItemExceptionHandler(OrderNotFoundException e){
        return e.getMessage();
    }

}
