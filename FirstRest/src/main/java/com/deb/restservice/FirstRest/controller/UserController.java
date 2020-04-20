package com.deb.restservice.FirstRest.controller;

import com.deb.restservice.FirstRest.dao.UserDAOService;
import com.deb.restservice.FirstRest.model.HelloWorldBean;
import com.deb.restservice.FirstRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   private UserDAOService userService;

    @GetMapping ("/users")
    public List<User> getUsers(){
        return userService.findAll();
   }
}
