package com.deb.restservice.FirstRest.controller;
import com.deb.restservice.FirstRest.model.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController{
    @RequestMapping(method=RequestMethod.GET, path="/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping (path="/helloAgain")
    public String hello1(){
        return "Hello World Once again";
    }

    @GetMapping (path="/HelloWorldBean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("Hello", "Mr Debasis");
    }
    @RequestMapping(method=RequestMethod.GET, path="/hello/{name}")
    public String helloPathVariable(@PathVariable String name){
        return "Hello :"+name;
    }
}