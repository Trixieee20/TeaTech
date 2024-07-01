package com.TeaTech.co.TeaTech.NotFoundException;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id){
        super("Could not found with " + id);
    }

}
