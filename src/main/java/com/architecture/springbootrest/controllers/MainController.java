package com.architecture.springbootrest.controllers;

import com.architecture.springbootrest.database.EmployeesRepository;
import com.architecture.springbootrest.models.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


@RestController
public class MainController {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public MainController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

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

    @PostMapping("/employee")
    ResponseEntity addEmployee(@Valid @RequestBody Employee requestData) {
        try {
            if( employeesRepository.save(requestData).equals(requestData)){

                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(requestData);
            };
        }catch (Error error){
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
        return (ResponseEntity) ResponseEntity.internalServerError();
    }

    @GetMapping("/employees")
    ResponseEntity getEmployees() {
        try {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(employeesRepository.findAll());
        }catch (Error error){
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }
}

