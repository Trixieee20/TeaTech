package com.TeaTech.co.TeaTech.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not found with " + id);
    }

}
