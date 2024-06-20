package com.TeaTech.co.TeaTech.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TeaTech.co.TeaTech.Model.UserModel;

@RestController
public class UserController {
    
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Trixie", "Trixiem@email.com", "Trixie20");

    }
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Trixie", "trixieemacalalad@gmail.com", "112002tam"));
        users.add(new UserModel(1, "JohnRey", "johnreycatibog@gmail.com", "111402jmc"));
        users.add(new UserModel(1, "MarkDaniel", "makealipustain@gmail.com", "011203mda"));
        return users;

    }
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Trixie", "trixieemacalalad@gmail.com", "112002tam");
    }
}
