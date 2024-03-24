//package com.architecture.springbootrest.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//        import jakarta.persistence.*;
//        import jakarta.validation.constraints.*;
//
//@Entity
//@Table(name = "products")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull(message = "Name cannot be null")
//    @Size(min = 1, max = 20, message = "Name range must be from 1 to 20 chars")
//    private String name;
//
//    @NotNull(message = "price cannot be null")
//    private int price;
//
//
//    public Product() {}
//
//    public Product(
//            String name,
//            int price
//    ) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public int getDeadlineTimestamp() {
//        return deadlineTimestamp;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public boolean getIsDone() {
//        return isDone;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public void setIsDone(boolean isDone) {
//        this.isDone = isDone;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public void setDeadlineTimestamp(int deadlineTimestamp) {
//        this.deadlineTimestamp = deadlineTimestamp;
//    }
//
//}
