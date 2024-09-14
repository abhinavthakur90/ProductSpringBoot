package com.wellsfargo.simplewebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/home")
    @ResponseBody
    public String greet(){
        return ("Welcome to Wells Fargo Home Page");
    }
    @RequestMapping("/about")
    @ResponseBody
    public String about(){
        return ("One of the Big 4 Banks of Unsited States of America!!");
    }
}
