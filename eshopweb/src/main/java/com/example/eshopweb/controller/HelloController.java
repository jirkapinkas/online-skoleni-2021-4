package com.example.eshopweb.controller;

import com.example.eshopweb.pojo.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping("/hello")
    public Message message() {
        return new Message("Spring Boot Works! :-)");
    }

    @GetMapping(path = "/dog", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] dog() throws IOException {
        return Files.readAllBytes(Path.of("files","dog.jpg"));
    }

}
