package com.architecture.springbootrest.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;


@RestController
public class HelloWorldController {
    @GetMapping("/")
    String root() {
        return "Spring hello world";
    }

    @GetMapping("/page")
    ResponseEntity htmlPage() {
        try {
            Resource resource = new ClassPathResource("static/htmlPage.html");
            byte[] data = Files.readAllBytes(resource.getFile().toPath());
            return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(data);
        }catch (Error error){
            return (ResponseEntity) ResponseEntity.internalServerError();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

