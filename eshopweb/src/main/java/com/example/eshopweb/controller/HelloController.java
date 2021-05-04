package com.example.eshopweb.controller;

import com.example.eshopweb.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping("/hello")
    public Message message() {
        return new Message("Spring Boot Works! :-)");
    }

}
