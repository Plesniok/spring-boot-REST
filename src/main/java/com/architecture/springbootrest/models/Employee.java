package com.architecture.springbootrest.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name cannot be null")
    @Size(min = 1, max = 20, message = "name range must be from 1 to 20 chars")
    private String name;

    @NotNull(message = "surname cannot be null")
    @Size(min = 1, max = 20, message = "surname range must be from 1 to 20 chars")
    private String surname;

    @NotNull(message = "position cannot be null")
    @Size(min = 1, max = 20, message = "position range must be from 1 to 20 chars")
    private String position;

    public Employee() {}

    public Employee(
            String name,
            String surname,
            String position
    ) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
