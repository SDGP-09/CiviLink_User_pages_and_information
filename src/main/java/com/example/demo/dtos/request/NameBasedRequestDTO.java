package com.example.demo.dtos.request;

public class NameBasedRequestDTO {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameBasedRequestDTO(String name) {
        this.name = name;
    }

    public NameBasedRequestDTO(){}
}
