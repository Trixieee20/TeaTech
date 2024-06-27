package com.TeaTech.co.TeaTech.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TeaTech.co.TeaTech.Model.User;
import com.TeaTech.co.TeaTech.NotFoundException.UserNotFoundException;
import com.TeaTech.co.TeaTech.Repository.UserRepository;

@RestController
public class UserController {

    UserRepository repo;

     public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return repo.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PostMapping("/user/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "Your account was added.";
    }

    @PutMapping("/user/edit/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(user ->{
            user.setName(newUser.getName());
            user.setAddress(newUser.getAddress());
            user.setContactNumber(newUser.getContactNumber());
            user.setAge(newUser.getAge());
            return repo.save(user);
        }).orElseGet(()->{
            return repo.save(newUser);
        });
        
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "A user is deleted!";
    }


    
}    