package com.example.demo.dtos.internal;

public class UserIdBasedInternalDTO {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserIdBasedInternalDTO(String id) {
        this.id = id;
    }

    public UserIdBasedInternalDTO(){}
}
