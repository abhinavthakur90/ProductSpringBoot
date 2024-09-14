package com.wellsfargo.simplewebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPage {
    @RequestMapping("/login")
    @ResponseBody
    public String login(){
    return ("Login Page>>>Enter your Login Details");
    }
}
