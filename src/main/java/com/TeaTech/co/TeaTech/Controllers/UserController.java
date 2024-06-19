package com.TeaTech.co.TeaTech.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeaTech.co.TeaTech.Model.UserModel;

@RestController
public class UserController {
    
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Trixie", "Trixiem@email.com", "Trixie20");

    }
   
}
