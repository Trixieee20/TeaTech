package com.TeaTech.co.TeaTech.NotFoundException;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found product with " + id);

    }
}
     


