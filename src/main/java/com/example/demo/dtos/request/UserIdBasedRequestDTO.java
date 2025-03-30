package com.example.demo.dtos.request;

public class UserIdBasedRequestDTO {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserIdBasedRequestDTO(String id) {
        this.id = id;
    }

    public UserIdBasedRequestDTO(){}
}
