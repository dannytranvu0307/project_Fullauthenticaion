package com.example.project_FullAuthentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/hello")
    public String helloworld(){
        return "hello world";
    }
}
