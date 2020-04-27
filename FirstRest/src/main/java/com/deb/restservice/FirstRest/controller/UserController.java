package com.deb.restservice.FirstRest.controller;

import com.deb.restservice.FirstRest.dao.UserDAOService;
import com.deb.restservice.FirstRest.exception.UserNotFoundException;
import com.deb.restservice.FirstRest.model.HelloWorldBean;
import com.deb.restservice.FirstRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

   @Autowired
   private UserDAOService userService;

    @GetMapping ("/users")
    public List<User> getUsers(){
        return userService.findAll();
   }
    /*@GetMapping ("/users/{userId}")
    public User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }
    */
    @GetMapping ("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.getUser(userId);
        if(user==null){
            throw new UserNotFoundException("Not found userId "+userId);
        }
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){return userService.save(user);}
    //create user and return the uri and status as created
    @PostMapping("/users1")
    public ResponseEntity<User> createUser1(@RequestBody User user){
        User createdUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(createdUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable int userId){
        User user = userService.deleteUserById(userId);
        if(user==null){
            throw new UserNotFoundException("Not found userId "+userId);
        }
        return user;
    }

}
